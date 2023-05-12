package com.jay.spring;

/**
 * @ClassName: BeanDefinition
 * @Description: bean定义  -- 定义bean的会有的属性
 * @Author: jay
 **/
public class BeanDefinition {
    /**
     * bean的类型
     */
    private Class clazz;
    /**
     * scope类型
     */
    private String scope;
    /**
     * 是不是懒加载
     */
    private boolean isLazy;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }
}
