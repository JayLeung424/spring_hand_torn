package com.spring.springframework.beans.factory;

import com.spring.springframework.beans.BeansException;

import java.util.Map;

/**
 * @ClassName: ListableBeanFactory
 * @Description: 扩展了BeanFactory接口，提供了获取所有Bean实例的方法
 * Extension of the {@link BeanFactory} interface to be implemented by bean factories
 * that can enumerate all their bean instances, rather than attempting bean lookup
 * by name one by one as requested by clients. BeanFactory implementations that
 * preload all their bean definitions (such as XML-based factories) may implement
 * this interface.
 * @Author: jay
 **/
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回 Bean 实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * @return 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();

}
