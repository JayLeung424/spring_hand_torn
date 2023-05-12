package com.jay.hand.service;

import com.jay.spring.*;

/**
 * @ClassName: UserService
 * @Description:
 * @Author: jay
 **/
@Component("userService")
@Scope("prototype")
public class UserService implements /*InitializingBean,*/ UserInterface,BeanNameAware{

    @Autowired
    private OrderService orderService;

    @JayValue("test")
    private String test;

    /**
     * 初始化之后 设置在容器的beanName
     */
    private String beanName;


    /**
     * 简单的test方法
     */
    @Override
    public void test() {
        System.out.println(test);
        System.out.println(beanName);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    // @Override
    // public void afterPropertiesSet() {
    //     System.out.println("初始化UserService");
    //
    //     //
    // }
}
