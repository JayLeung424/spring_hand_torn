package com.jay.hand.service;

import com.jay.spring.BeanPostProcessor;
import com.jay.spring.Component;

import java.lang.reflect.Proxy;

/**
 * @ClassName: JayBeanPostProcessor
 * @Description: 重写 BeanPostProcessor 接口
 * @Author: jay
 **/
@Component
public class JayBeanPostProcessor implements BeanPostProcessor {

    /**
     * 该方法在bean对象执行初始化方法之前执行
     *
     * @param bean
     * @param beanName
     * @return
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("初始化之前执行");
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
        // 如果针对某一个bean才处理
        if ("userService".equals(beanName)) {
            // 使用动态代理
            Object proxyInstance = Proxy.newProxyInstance(this.getClass().getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                // 切面逻辑
                System.out.println("切面逻辑");
                return method.invoke(bean, args);
            });
            return proxyInstance;
        }
        return bean;
    }
}
