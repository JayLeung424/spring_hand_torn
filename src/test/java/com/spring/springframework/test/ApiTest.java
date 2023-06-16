package com.spring.springframework.test;

import com.spring.springframework.beans.factory.config.BeanDefinition;
import com.spring.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.spring.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @ClassName: ApiTest
 * @Description: 单测
 * @Author: jay
 **/
public class ApiTest {

    @Test
    public void testBeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4.第二次获取bean from Singleton
        UserService userServiceSingle = (UserService) beanFactory.getBean("userService");
        userServiceSingle.queryUserInfo();
    }
}
