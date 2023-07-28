package com.spring.springframework.test.bean;

/**
 * @ClassName: UserService
 * @Description: 简单的 UserService对象，方便我们后续对 Spring 容器测试
 * @Author: jay
 **/
public class UserService{

    private String userId;
    private IUserDao userDao;
    private String company;
    private String location;
    public String queryUserInfo() {
        return userDao.queryUserName(userId) + "," + company + "," + location;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
