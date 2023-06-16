package com.spring.springframework.beans.factory.support;

import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.factory.BeanFactory;
import com.spring.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName: AbstractBeanFactory
 * @Description: 抽象类定义模板方法(AbstractBeanFactory)
 * 继承了 DefaultSingletonBeanRegistry可以存取（注册）单例对象
 * 继承了 BeanFactory 并且定义 getBeanDefinition 和 createBean
 * @Author: jay
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        // 从单例池中获取bean
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
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
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
