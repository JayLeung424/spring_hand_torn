package com.spring.springframework.test;

import com.spring.springframework.beans.factory.PropertyValue;
import com.spring.springframework.beans.factory.PropertyValues;
import com.spring.springframework.beans.factory.config.BeanDefinition;
import com.spring.springframework.beans.factory.config.BeanReference;
import com.spring.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.spring.springframework.test.bean.UserDao;
import com.spring.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;

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
        // 2.注册 userDao
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        // 3. UserService 设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. UserService 注入 Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. 获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();

    }


}
