package com.spring.springframework.beans.factory.config;

import com.spring.springframework.beans.factory.PropertyValues;

/**
 * @ClassName: BeanDefinition
 * @Description: Bean定义  -- 定义Bean的会有的属性
 * @Author: jay
 **/
public class BeanDefinition {

    /**
     * Bean 对象
     * step1->step2 的变化 是 由存储bean对象改为存储类信息
     */
    private Class beanClass;

    /**
     * 属性集合
     */
    private PropertyValues propertyValues;


    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
