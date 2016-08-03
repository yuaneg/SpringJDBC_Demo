package com.yuan.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * spring 默认scope 全容器共享一个bean 每个bean都是相等的
 * @author yuaneg
 *
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class FirstBean {
	
}
