package com.spring.springframework.context.support;

import com.spring.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.spring.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @ClassName: AbstractXmlApplicationContext
 * @Description:上下文中对配置信息的加载
 * @Author: jay
 **/
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    /**
     * 获取配置文件路径
     *
     * @return
     */
    protected abstract String[] getConfigLocations();

}
