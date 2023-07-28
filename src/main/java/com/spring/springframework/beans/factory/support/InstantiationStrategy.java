package com.spring.springframework.beans.factory.support;

import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;


/**
 * @ClassName: InstantiationStrategy
 * @Description: Bean实例化策略
 * @Author: jay
 **/
public interface InstantiationStrategy {

    /**
     * 实例化 Bean
     *
     * @param beanDefinition Bean 定义
     * @param beanName       Bean 名称
     * @param ctor           java.lang.reflect包下的Constructor类，可以拿到符合入参信息相对应的构造函数。
     * @param args           构造参数
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
