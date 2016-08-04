package com.yuan.aop.aop;

import org.springframework.stereotype.Component;

@Component
public class DemoService {
	
	public void add(){
		System.out.println("执行方法");
	}
	
}
