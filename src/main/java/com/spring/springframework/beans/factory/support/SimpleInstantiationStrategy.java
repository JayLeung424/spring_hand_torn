package com.spring.springframework.beans.factory.support;

import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @ClassName: SimpleInstantiationStrategy
 * @Description: JDK的实例化策略
 * @Author: jay
 **/
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        // 获取bean的class对象
        Class clazz = beanDefinition.getBeanClass();
        if (clazz == null) {
            return null;
        }
        try {
            // 如果指定了构造函数，则调用指定的构造函数实例化
            if (ctor != null) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                // 如果没有指定构造函数，则调用无参构造函数实例化
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
