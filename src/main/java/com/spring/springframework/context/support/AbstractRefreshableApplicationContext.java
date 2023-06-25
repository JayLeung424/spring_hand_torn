package com.spring.springframework.context.support;

import com.spring.springframework.beans.BeansException;
import com.spring.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.spring.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @ClassName: AbstractRefreshableApplicationContext
 * @Description: 抽象可刷新的应用上下文
 * @Author: jay
 **/
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * 加载bean定义
     *
     * @param beanFactory
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
