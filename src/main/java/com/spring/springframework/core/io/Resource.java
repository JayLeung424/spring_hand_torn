package com.spring.springframework.core.io;

import com.spring.springframework.beans.BeansException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: Resource
 * @Description: 资源加载接口
 * @Author: jay
 **/
public interface Resource {

    /**
     * 获取输入流
     *
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
