package com.spring.springframework.beans.factory;

import com.spring.springframework.beans.BeansException;

/**
 * @ClassName: BeanFactory
 * @Description: Bean 对象的工厂,可以存放 Bean 定义到 Map 中以及获取。
 * @Author: jay
 **/
public interface BeanFactory {

    /**
     * 获取 Bean
     *
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

}
