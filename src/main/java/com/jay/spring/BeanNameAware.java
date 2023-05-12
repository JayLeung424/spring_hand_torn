package com.jay.spring;

/**
 * @ClassName: BeanPostProcessor
 * @Description: Bean的后置处理器
 * @Author: jay
 */
public interface BeanNameAware {


	/**
	 * 设置bean的名字
	 * @param name
	 */
	void setBeanName(String name);

}
