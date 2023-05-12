package com.jay.hand.service;

import com.jay.hand.service.JayValue;
import com.jay.spring.BeanPostProcessor;
import com.jay.spring.Component;

import java.lang.reflect.Field;

/**
 * @ClassName: JayValueBeanPostProcessor
 * @Description: 针对 @JauValue 注解, 进行初始化前后的处理
 * @Author: jay
 **/
@Component
public class JayValueBeanPostProcessor implements BeanPostProcessor {

    /**
     * 该方法在bean对象执行初始化方法之前执行
     *
     * @param bean
     * @param beanName
     * @return
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        // 将注解中的value赋值给属性
        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(JayValue.class)){
                field.setAccessible(true);
                try {
                    field.set(bean,field.getAnnotation(JayValue.class).value());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bean;
    }

    /**
     * 该方法在bean对象执行初始化方法之后执行
     *
     * @param bean
     * @param beanName
     * @return
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
