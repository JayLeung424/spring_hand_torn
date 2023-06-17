package com.spring.springframework.test.bean;

/**
 * @ClassName: UserService
 * @Description: 简单的 UserService对象，方便我们后续对 Spring 容器测试
 * @Author: jay
 **/
public class UserService {
    private String name;
    //
    // public UserService() {
    // }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息:" + name);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }

}
