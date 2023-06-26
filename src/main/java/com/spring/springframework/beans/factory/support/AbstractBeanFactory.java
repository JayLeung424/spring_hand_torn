package com.spring.springframework.beans.factory.support;

import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.factory.BeanFactory;
import com.spring.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName: AbstractBeanFactory
 * @Description: BeanDefinition注册表接口
 * 继承了 DefaultSingletonBeanRegistry可以存取（注册）单例对象
 * 继承了 BeanFactory 并且定义 getBeanDefinition 和 createBean
 * @Author: jay
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    /**
     * 获取bean
     *
     * @param beanName
     * @param args
     * @return
     */
    protected <T> T doGetBean(final String beanName, final Object[] args) {
        // 从单例池中获取bean
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T) createBean(beanName, beanDefinition, args);
    }

    /**
     * 获取bean
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 创建bean
     *
     * @param beanName       bean名称
     * @param beanDefinition bean定义
     * @param args           参数
     * @return bean实例
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
