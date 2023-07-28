package com.spring.springframework.beans.factory;

/**
 * @ClassName: BeanClassLoaderAware
 * @Description: 实现此接口， 能感知到所属的BeanName
 * @Author: jay
 **/
public interface BeanNameAware extends Aware{

    /**
     * 设置BeanName
     * @param name bean名称
     */
    void setBeanName(String name);
}
