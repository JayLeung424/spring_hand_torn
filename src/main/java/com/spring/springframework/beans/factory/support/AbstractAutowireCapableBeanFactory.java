package com.spring.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.PropertyValue;
import com.spring.springframework.beans.PropertyValues;
import com.spring.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.spring.springframework.beans.factory.config.BeanDefinition;
import com.spring.springframework.beans.factory.config.BeanPostProcessor;
import com.spring.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @ClassName: AbstractAutowireCapableBeanFactory
 * @Description: 继承 AbstractBeanFactory 类，实现了 createBean 方法
 * @Author: jay
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            // bean的实例化
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 给Bean 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
            // 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 存放到单例对象的缓存
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * bean的实例化
     *
     * @param beanDefinition
     * @param beanName
     * @param args
     * @return
     */
    private Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructor = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 获取到所有的构造函数
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        // 将构造函数的参数个数与传入的参数个数进行比较，如果相等，则获取该构造函数
        for (Constructor<?> ctor : declaredConstructors) {
            // 目前只有数量的比较，没有类型的比较
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructor = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor, args);
    }

    /**
     * 给Bean 填充属性
     *
     * @param beanName       bean的名称
     * @param bean           bean的实例
     * @param beanDefinition bean的定义
     */
    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            if (propertyValues == null) {
                return;
            }
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }

    }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    /**
     * 初始化Bean
     *
     * @param beanName       bean的名称
     * @param bean           bean的实例
     * @param beanDefinition bean的定义
     * @return
     */
    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 1. 执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // 待完成内容：invokeInitMethods(beanName, wrappedBean, beanDefinition);
        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        // 2. 执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {

    }

    /**
     * 执行Bean的初始化方法的前置处理
     *
     * @param existingBean bean的实例
     * @param beanName     bean的名称
     * @return
     */
    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (current == null) {
                return result;
            }
            result = current;
        }
        return result;
    }

    /**
     * 执行Bean的初始化方法的后置处理
     *
     * @param existingBean bean的实例
     * @param beanName     bean的名称
     * @return
     * @throws BeansException
     */
    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }


}
