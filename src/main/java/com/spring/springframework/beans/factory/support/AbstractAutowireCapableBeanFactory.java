package com.spring.springframework.beans.factory.support;

import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @ClassName: AbstractAutowireCapableBeanFactory
 * @Description: 继承 AbstractBeanFactory 类，实现了 createBean 方法
 * @Author: jay
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException {
        Object bean = null;
        try {
            // bean的实例化
            // bean = beanDefinition.getBeanClass().newInstance();
            bean =  createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 存放到单例对象的缓存
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * bean的实例化
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


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
