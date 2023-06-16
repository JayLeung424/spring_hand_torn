package com.spring.springframework;

/**
 * @ClassName: BeanDefinition
 * @Description: Bean定义  -- 定义Bean的会有的属性
 * @Author: jay
 **/
public class BeanDefinition {
    /**
     * Bean 对象
     */
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
