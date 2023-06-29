package com.spring.springframework.context;

import com.spring.springframework.beans.BeansException;

/**
 * @ClassName: ConfigurableApplicationContext
 * @Description: 可配置的应用上下文接口
 * @Author: jay
 **/
public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 注册关闭钩子
     */
    void registerShutdownHook();

    /**
     * 关闭容器
     */
    void close();
}
