package com.spring.springframework.context;

import com.spring.springframework.beans.factory.HierarchicalBeanFactory;
import com.spring.springframework.beans.factory.ListableBeanFactory;
import com.spring.springframework.core.io.ResourceLoader;

/**
 * @ClassName: ApplicationContext
 * @Description: 应用上下文
 * @Author: jay
 **/
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}

