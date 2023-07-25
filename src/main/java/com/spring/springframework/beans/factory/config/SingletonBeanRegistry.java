package com.spring.springframework.beans.factory.config;

/**
 * @ClassName: SingletonBeanRegistry
 * @Description: 获取单例对象的接口类
 * @Author: jay
 **/
public interface SingletonBeanRegistry {
    /**
     * 获取单例对象
     *
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
