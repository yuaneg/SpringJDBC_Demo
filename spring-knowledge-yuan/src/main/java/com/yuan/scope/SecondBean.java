package com.yuan.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
/**
 * 每次调用都会创建一个新的bean
 * @author yuaneg
 *
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SecondBean {
	
}
