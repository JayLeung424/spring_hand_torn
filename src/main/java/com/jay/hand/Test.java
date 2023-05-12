package com.jay.hand;

import com.jay.hand.service.UserInterface;
import com.jay.spring.JayApplicationContext;

/**
 * @ClassName: Test
 * @Description: 启动类
 * @Author: jay
 * @Date: 2023/5/11 16:48
 **/
public class Test {

    public static void main(String[] args) {

        // 扫描 -> 创建单例Bean
        JayApplicationContext applicationContext = new JayApplicationContext(AppConfig.class);

        // 从容器中获取对象 getBean
        UserInterface userService = (UserInterface) applicationContext.getBean("userService");

        userService.test();

    }
}
