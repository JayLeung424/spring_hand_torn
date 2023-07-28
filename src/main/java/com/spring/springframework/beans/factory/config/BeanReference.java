package com.spring.springframework.beans.factory.config;

/**
 * @ClassName: BeanReference
 * @Description: Bean的引用
 * @Author: jay
 **/
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
