package com.yuan.aware.test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuan.scope.FirstBean;
import com.yuan.scope.SecondBean;

public class ScopeTest {
	
	ApplicationContext application;

	@Before
	public void before(){
		this.application = new  ClassPathXmlApplicationContext("spring/application-config.xml");
	}
	
	/**
	 * bean 相等
	 */
	@Test
	public void test() {
		FirstBean f1 = application.getBean(FirstBean.class);
		FirstBean f2 = application.getBean(FirstBean.class);
		assertTrue(f1 == f2);
	}
	
	/**
	 * bean 不相等
	 */
	@Test
	public void test2() {
		SecondBean s1 = application.getBean(SecondBean.class);
		SecondBean s2 = application.getBean(SecondBean.class);
		assertTrue(s1 != s2);
	}
}
