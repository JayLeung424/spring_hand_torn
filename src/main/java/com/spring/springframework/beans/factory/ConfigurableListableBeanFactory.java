package com.spring.springframework.beans.factory;


import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.spring.springframework.beans.factory.config.BeanDefinition;
import com.spring.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @ClassName: AutowireCapableBeanFactory
 * @Description: Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 * @Author: jay
 **/
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    /**
     * 根据Bean名称获取BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
