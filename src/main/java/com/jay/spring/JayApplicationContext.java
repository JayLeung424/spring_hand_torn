package com.jay.spring;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.*;

/**
 * @ClassName: JayApplicationContext
 * @Description:
 * @Author: jay
 **/
public class JayApplicationContext {

    /**
     * 配置类,接受属性
     */
    private Class configClass;

    /**
     * bean定义map
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 单例池
     */
    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * Bean后置处理器集合
     */
    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public JayApplicationContext(Class configClass) {
        this.configClass = configClass;

        // 扫描
        scan(configClass);

        // 创建
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            if ("singleton".equals(beanDefinition.getScope())) {
                // 创建bean 并放到单例池中
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName,bean);
            }
        }
    }


    /**
     * 从容器中获取对象 getBean
     * 核心: 根据beanName获取到对应的BeanDefinition 然后创建对象
     * beanName --> UserService.class --> 还要再判断单例还是原型(又要解析)  显得麻烦且重复 ---> 引出 BeanDefinition
     *
     * @param beanName bean的名字
     * @return
     */
    public Object getBean(String beanName) {
        if (!beanDefinitionMap.containsKey(beanName)) {
            throw new NullPointerException("不存在该bean");
        }
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        // 判断scope 是单例还是原型
        if ("singleton".equals(beanDefinition.getScope())) {
            // 单例从单例池直接拿
            Object singletonBean = singletonObjects.get(beanName);
            // 这一步 目的是: UserService类中 有OrderService, 如果没有这个判断，那么orderService再UserService加载时候，是null
            // 上层是 有@Autowired注解,要帮助createBean
            if (singletonBean == null){
                singletonBean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName,singletonBean);
            }
            return singletonBean;
        } else {
            // 原型
            Object prototypeBean = createBean(beanName, beanDefinition);
            return prototypeBean;
        }
    }

    /**
     * 扫描
     *
     * @param configClass
     */
    private void scan(Class configClass) {
        // 判断当前类上是否有扫描注解
        if (!configClass.isAnnotationPresent(ComponentScan.class)) {
            return;
        }
        // 1、拿扫描的路径 ---> 拿到注解对象 获取对应值 = 扫描路径
        ComponentScan componentScanAnnotation = (ComponentScan) this.configClass.getAnnotation(ComponentScan.class);
        String path = componentScanAnnotation.value();

        // System.out.println("扫描路径:" + path); // com.jay.spring.service
        // 2、扫描路径下的所有类
        ClassLoader classLoader = JayApplicationContext.class.getClassLoader();
        // 转为文件path  com.jay.spring.service -> com/jay/spring/service (相对路径 -> 刚好对应的是target/classes下的文件夹)
        URL resource = classLoader.getResource(path.replace(".", "/"));

        // 3、获取文件夹下的所有文件
        File file = new File(resource.getFile());
        if (!file.isDirectory()) {
            return;
        }
        // 如果是文件夹 递归获取
        for (File f : Objects.requireNonNull(file.listFiles())) {
            String absolutePath = f.getAbsolutePath();
            // 打印出包下的类的绝对路径
            // System.out.println(absolutePath);  /Users/jay/Documents/code/my_code/java/spring/spring_hand_torn/spring_hand_torn/target/classes/com/jay/hand/service/UserService.class
            // classLoader.loadClass() 传入的是类的全限定名 （com.jay.hand.service.UserService）
            absolutePath = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class")).replace("/", ".");
            // System.out.println(absolutePath); // com.jay.hand.service.UserService

            try {
                Class<?> clazz = classLoader.loadClass(absolutePath);
                // 4、反射获取类上的注解 判断是不是@Component
                if (clazz.isAnnotationPresent(Component.class)) {

                    // 判断是否实现了BeanPostProcessor接口
                    if (BeanPostProcessor.class.isAssignableFrom(clazz)){
                        // 放到容器中
                        BeanPostProcessor instance = (BeanPostProcessor) clazz.getConstructor().newInstance();
                        // 将实现了BeanPostProcessor接口的缓存起来
                        beanPostProcessorList.add(instance);
                    }

                    // 初始化BeanDefinition 并放到容器中
                    BeanDefinition beanDefinition = new BeanDefinition();
                    beanDefinition.setClazz(clazz);

                    // 5、判断是单例还是原型
                    // 单例：在容器中只保存一份  原型：每次获取都要创建一个新的对象
                    if (clazz.isAnnotationPresent(Scope.class)) {
                        // 有的话要判断 具体内容是什么
                        Scope scopeAnnotation = clazz.getAnnotation(Scope.class);
                        beanDefinition.setScope(scopeAnnotation.value());
                    } else {
                        // 默认是单例
                        beanDefinition.setScope("singleton");
                    }

                    // 获取bean的名字
                    String beanName = clazz.getAnnotation(Component.class).value();
                    // 如果有Component注解 但是没有名字，默认设置为类名首字母小写
                    if ("".equals(beanName)) {
                        // 如果没有指定名字 默认是类名首字母小写
                        beanName = Introspector.decapitalize(clazz.getSimpleName());
                    }
                    // 每扫描到一个Bean 在容器中保存一份
                    beanDefinitionMap.put(beanName, beanDefinition);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * 创建对象Bean
     *
     * @param beanName       bean的名字
     * @param beanDefinition bean的定义
     * @return
     */
    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class clazz = beanDefinition.getClazz();
        Object instance = null;
        try {
            /**
             * Spring的判断逻辑如下：
             * 1. 如果一个类只存在一个构造方法，不管该构造方法是无参构造方法，还是有参构造方法，Spring都会用这个构造方法
             * 2. 如果一个类存在多个构造方法
             *   a. 这些构造方法中，存在一个无参的构造方法，那么Spring就会用这个无参的构造方法
             *   b. 这些构造方法中，不存在一个无参的构造方法，那么Spring就会报错
             */
            instance = clazz.getConstructor().newInstance();

            // 依赖注入
            for (Field field : clazz.getDeclaredFields()) {
                // 判断属性上是否有Autowired注解 有的话就赋值
                if (field.isAnnotationPresent(Autowired.class)) {
                    // 设置属性的值
                    field.setAccessible(true);
                    // 获取属性的名字
                    String fieldName = field.getName();
                    // 根据属性名字获取对应的bean
                    Object bean = getBean(fieldName);
                    field.set(instance, bean);
                }
            }

            // Aware回调 设置beanName

            // 初始化之前的方法
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
            }

            // 初始化
            if (instance instanceof InitializingBean) {
                ((InitializingBean) instance).afterPropertiesSet();
            }

            // BeanPostProcessor
            // 初始化之后的方法
            // new JayBeanPostProcessor().postProcessAfterInitialization(instance, beanName); 写法太low 在JayBeanPostProcessor设置@Compont

            // 在扫描时候设置好缓存, 从缓存中拿到
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                // 每一个bean都会执行该方法
                // instance 现在变成了代理对象
                instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
            }


        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }
}

