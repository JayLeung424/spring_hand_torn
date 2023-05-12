package com.jay.spring;

/**
 * @ClassName: InitializingBean
 * @Description: 初始化Bean
 * @Author: jay
 **/
public interface InitializingBean {

    /**
     * 初始化方法
     */
    void afterPropertiesSet();

}
