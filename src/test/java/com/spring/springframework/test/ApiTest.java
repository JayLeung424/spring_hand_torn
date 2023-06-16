package com.spring.springframework.test;

import com.spring.springframework.BeanDefinition;
import com.spring.springframework.BeanFactory;
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
        BeanFactory beanFactory = new BeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
