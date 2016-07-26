package com.yuan.aware.applicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HelloBean implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	private String helloWord = "Hello!World!";

	public void setApplicationContext(ApplicationContext context) {
		this.applicationContext = context;
	}

	public void setHelloWord(String helloWord) {
		this.helloWord = helloWord;
	}
	
	public String getHelloWord() {
		//被传播  到 propertygettedEvent 
		applicationContext.publishEvent(new PropertyGettedEvent("[" + helloWord + "] is getted"));
		return helloWord;
	}
	/**
	 * 当 helloBean 被销毁时执行的方法
	 */
	public void shutDown(){
		// 实例法被进行销毁时消息并没有被传播出去
		applicationContext.publishEvent(new PropertyGettedEvent("[" + helloWord + "] is getted"));
		System.out.println("方法被销毁");
	}
}
