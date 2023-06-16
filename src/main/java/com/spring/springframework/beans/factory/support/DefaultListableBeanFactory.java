package com.spring.springframework.beans.factory.support;

import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DefaultListableBeanFactory
 * @Description: BeanDefinitionRegistry接口的默认实现类
 * 继承了AbstractAutowireCapableBeanFactory类，可以 createBean
 * 同时继承了 AbstractBeanFactory 类，拥有了 beanDefinitionMap 容器的存取功能
 * 对 BeanDefinition容器、单例容器两个核心容器的操作权限
 *
 * @Author: jay
 **/
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
