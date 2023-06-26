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
     * @param beanName Bean名称
     * @return Bean对象
     * @throws BeansException
     */
    Object getBean(String beanName) throws BeansException;


    /**
     * 获取 Bean
     * step2->step3 : Bean对象初始化支持有参构造函数
     *
     * @param beanName Bean名称
     * @param args     构造函数参数
     * @return Bean对象
     * @throws BeansException
     */
    Object getBean(String beanName, Object... args) throws BeansException;


}
