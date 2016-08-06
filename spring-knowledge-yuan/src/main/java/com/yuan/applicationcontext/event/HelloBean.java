package com.yuan.applicationcontext.event;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component()
public class HelloBean implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	
	//通过@Value 为hello world 注入属性
	@Value("Hello!Justin!")
	private String helloWord;

	public void setApplicationContext(ApplicationContext context) {
		this.applicationContext = context;
	}

	public void setHelloWord(String helloWord) {
		this.helloWord = helloWord;
	}

	public String getHelloWord() {
		// 被传播 到 propertygettedEvent
		applicationContext.publishEvent(new PropertyGettedEvent("[" + helloWord + "] is getted"));
		return helloWord;
	}

	/**
	 * 当 helloBean 被销毁时执行的方法
	 */
	public void shutDown() {
		// 实例法被进行销毁时消息并没有被传播出去
		// listener没有监听到  <bean  destroy-method="shutDown">
		applicationContext.publishEvent(new PropertyGettedEvent("[" + helloWord + "] is getted"));
		System.out.println("方法被销毁");
	}
}
