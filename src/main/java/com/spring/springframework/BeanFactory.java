package com.spring.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: BeanFactory
 * @Description: Bean 对象的工厂,可以存放 Bean 定义到 Map 中以及获取。
 * @Author: jay
 **/
public class BeanFactory {
    /**
     * 存放 Bean 定义的 Map
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 获取 Bean
     *
     * @param name
     * @return
     */
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * 注册 Bean 定义
     *
     * @param name           Bean 名称
     * @param beanDefinition Bean 定义
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
