package com.spring.springframework.test.common;


import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.PropertyValue;
import com.spring.springframework.beans.PropertyValues;
import com.spring.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.spring.springframework.beans.factory.config.BeanDefinition;
import com.spring.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
