package com.spring.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.URL;

/**
 * @ClassName: DefaultResourceLoader
 * @Description: 默认资源加载器
 * @Author: jay
 **/
public class DefaultResourceLoader implements ResourceLoader {
    /**
     * 根据资源地址加载资源
     * 默认定义好了三类 url,classpath,file
     *
     * @param location 资源地址
     * @return
     */
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        // 判断是否是 classpath 路径
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                // 尝试作为 URL 路径进行加载
                return new UrlResource(new URL(location));
            } catch (Exception e) {
                // 尝试作为文件路径进行加载
                return new FileSystemResource(location);
            }
        }
    }
}
