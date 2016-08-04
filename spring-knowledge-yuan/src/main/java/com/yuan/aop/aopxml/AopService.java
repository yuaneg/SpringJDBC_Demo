package com.yuan.aop.aopxml;

import org.springframework.stereotype.Component;

@Component
public class AopService {
	
	/**
	 * 通过xml配置
	 */
	public void add(){
		System.out.println("被切入的方法");
	}
	
}
