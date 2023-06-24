package com.spring.springframework.beans.factory.support;

import com.spring.springframework.beans.BeansException;
import com.spring.springframework.core.io.Resource;
import com.spring.springframework.core.io.ResourceLoader;

/**
 * @ClassName: BeanDefinitionReader
 * @Description: Bean定义读取器
 * @Author: jay
 **/
public interface BeanDefinitionReader {
    /**
     * 加载Bean定义
     *
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     * @return
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载Bean定义
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    /**
     * 加载Bean定义
     * @param resources
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 加载Bean定义
     * @param location
     * @throws BeansException
     */
    void loadBeanDefinitions(String location) throws BeansException;

}
