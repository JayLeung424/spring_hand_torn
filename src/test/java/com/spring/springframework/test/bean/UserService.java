package com.spring.springframework.test.bean;

import com.spring.springframework.beans.factory.DisposableBean;
import com.spring.springframework.beans.factory.InitializingBean;

/**
 * @ClassName: UserService
 * @Description: 简单的 UserService对象，方便我们后续对 Spring 容器测试
 * @Author: jay
 **/
public class UserService implements InitializingBean, DisposableBean {

    private String userId;

    private UserDao userDao;
    private String company;
    private String location;

    public String queryUserInfo() {
        return userDao.queryUserName(userId) + "," + company + "," + location;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
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
