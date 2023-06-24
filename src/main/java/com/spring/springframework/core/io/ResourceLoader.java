package com.spring.springframework.core.io;

/**
 * @ClassName: ResourceLoader
 * @Description: 包装资源加载器
 * @Author: jay
 **/
public interface ResourceLoader {
    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 根据资源地址获取资源
     *
     * @param location 资源地址
     * @return
     */
    Resource getResource(String location);

}
