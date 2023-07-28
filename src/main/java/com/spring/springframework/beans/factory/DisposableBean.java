package com.spring.springframework.beans.factory;

/**
 * @ClassName: DisposableBean
 * @Description: 定义销毁bean的接口
 * @Author: jay
 **/
public interface DisposableBean {

    /**
     * 销毁bean
     *
     * @throws Exception
     */
    void destroy() throws Exception;
}
