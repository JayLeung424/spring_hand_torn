package com.spring.springframework.beans.factory.support;

import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @ClassName: CglibSubclassingInstantiationStrategy
 * @Description: cglib 实例化策略
 * @Author: jay
 **/
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        // 设置回调方法
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        // 如果没有指定构造函数，则调用无参构造函数实例化
        if (ctor == null) {
            return enhancer.create();
        }
        // 如果指定了构造函数，则调用指定的构造函数实例化
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
