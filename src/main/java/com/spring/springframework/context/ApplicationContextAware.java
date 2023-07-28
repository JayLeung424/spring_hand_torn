package com.spring.springframework.context;

import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.factory.Aware;

/**
 * @ClassName: ApplicationContextAware
 * @Description: 标记类接口，既能感知到所属的 ApplicationContext
 * @Author: jay
 **/
public interface ApplicationContextAware extends Aware {

    /**
     * 设置 ApplicationContext
     *
     * @param applicationContext 应用上下文
     * @throws BeansException 异常
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
