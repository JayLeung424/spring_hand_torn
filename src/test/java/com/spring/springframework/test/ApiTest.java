package com.spring.springframework.test;

import com.spring.springframework.beans.PropertyValue;
import com.spring.springframework.beans.PropertyValues;
import com.spring.springframework.beans.factory.config.BeanDefinition;
import com.spring.springframework.beans.factory.config.BeanReference;
import com.spring.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.spring.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.spring.springframework.test.bean.UserDao;
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
        // 2.读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        // 3.获取Bean对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService");
        System.out.println(userService.queryUserInfo());
    }


}
