package com.spring.springframework.core.io;

import cn.hutool.core.lang.Assert;
import com.spring.springframework.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: ClassPathResource
 * @Description: 类路径资源加载
 * 用于通过 ClassLoader 读取ClassPath 下的文件信息
 * @Author: jay
 **/
public class ClassPathResource implements Resource {

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    /**
     * 获取输入流
     * 用于通过 ClassLoader 读取ClassPath 下的文件信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream inputStream = classLoader.getResourceAsStream(path);
        if (inputStream == null) {
            throw new IOException(this.path + " can not open classpath resource: " + path);
        }
        return inputStream;
    }
}
