package com.spring.springframework.beans.factory;

/**
 * @ClassName: BeanClassLoaderAware
 * @Description: 能感知到所属的ClassLoader
 * @Author: jay
 **/
public interface BeanClassLoaderAware extends Aware{

    /**
     * 设置类加载器
     * @param classLoader 类加载器
     */
    void setBeanClassLoader(ClassLoader classLoader);
}
