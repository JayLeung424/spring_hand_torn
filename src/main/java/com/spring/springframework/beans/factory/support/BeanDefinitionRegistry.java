package com.spring.springframework.beans.factory.support;


import com.spring.springframework.beans.factory.config.BeanDefinition;

/**
 * @ClassName: BeanDefinitionRegistry
 * @Description: 定义注册 BeanDefinition 的接口
 * @Author: jay
 **/
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
