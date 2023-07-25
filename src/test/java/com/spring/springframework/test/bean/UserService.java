package com.spring.springframework.test.bean;

import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.factory.BeanClassLoaderAware;
import com.spring.springframework.beans.factory.BeanFactory;
import com.spring.springframework.beans.factory.BeanFactoryAware;
import com.spring.springframework.beans.factory.BeanNameAware;
import com.spring.springframework.context.ApplicationContext;
import com.spring.springframework.context.ApplicationContextAware;

/**
 * @ClassName: UserService
 * @Description: 简单的 UserService对象，方便我们后续对 Spring 容器测试
 * @Author: jay
 **/
public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private String userId;

    private UserDao userDao;
    private String company;
    private String location;

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }

    public String queryUserInfo() {
        return userDao.queryUserName(userId) + "," + company + "," + location;
    }

    // @Override
    // public void destroy() throws Exception {
    //     System.out.println("执行：UserService.destroy");
    // }
    //
    // @Override
    // public void afterPropertiesSet() throws Exception {
    //     System.out.println("执行：UserService.afterPropertiesSet");
    // }


    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
