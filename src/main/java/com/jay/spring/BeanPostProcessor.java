package com.jay.spring;

/**
 * @ClassName: BeanPostProcessor
 * @Description: Bean的后置处理器
 * @Author: jay
 */
public interface BeanPostProcessor {

    /**
     * 该方法在bean对象执行初始化方法之前执行
     *
     * @param bean
     * @param beanName
     * @return
     */
    default Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    /**
     * 该方法在bean对象执行初始化方法之后执行
     *
     * @param bean
     * @param beanName
     * @return
     */
    default Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }

}
