package com.spring.springframework.beans.factory.config;

import com.spring.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @ClassName: ConfigurableBeanFactory
 * @Description:
 * @Author: jay
 **/
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    /**
     * 添加 BeanPostProcessor
     *
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
