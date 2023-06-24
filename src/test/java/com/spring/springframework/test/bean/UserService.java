package com.spring.springframework.test.bean;

/**
 * @ClassName: UserService
 * @Description: 简单的 UserService对象，方便我们后续对 Spring 容器测试
 * @Author: jay
 **/
public class UserService {

    private String userId;

    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(userId);
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
}
