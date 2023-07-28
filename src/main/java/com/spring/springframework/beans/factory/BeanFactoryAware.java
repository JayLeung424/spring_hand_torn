package com.spring.springframework.beans.factory;


import com.spring.springframework.beans.BeansException;

/**
 * @ClassName: BeanClassLoaderAware
 * @Description: 实现此接口， 能感知到所属的BeanFactory
 * @Author: jay
 **/
public interface BeanFactoryAware extends Aware {

    /**
     * 设置BeanFactory
     *
     * @param beanFactory bean工厂
     * @throws BeansException 异常
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
