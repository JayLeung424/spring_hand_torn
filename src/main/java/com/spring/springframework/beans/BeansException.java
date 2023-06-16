package com.spring.springframework.beans;

/**
 * @ClassName: BeansException
 * @Description: 定义 Bean 异常
 * @Author: jay
 **/

public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}