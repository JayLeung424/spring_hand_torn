package com.spring.springframework.context.support;

import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.factory.config.BeanPostProcessor;
import com.spring.springframework.context.ApplicationContext;
import com.spring.springframework.context.ApplicationContextAware;

/**
 * @ClassName: ApplicationContextAwareProcessor
 * @Description:
 * @Author: jay
 **/
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
