package com.spring.springframework.beans.factory.support;

import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName: AbstractAutowireCapableBeanFactory
 * @Description: 继承 AbstractBeanFactory 类，实现了 createBean 方法
 * @Author: jay
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            // bean的实例化
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 存放到单例对象的缓存
        addSingleton(beanName, bean);
        return bean;
    }
}
