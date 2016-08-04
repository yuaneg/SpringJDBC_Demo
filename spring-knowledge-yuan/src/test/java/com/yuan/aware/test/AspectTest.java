package com.yuan.aware.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuan.aop.annotationaop.DemoAnnotationService;
import com.yuan.aop.aop.DemoService;
import com.yuan.aop.aopxml.AopService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class AspectTest {
	
	@Autowired
	private DemoAnnotationService demoAnnotationService;
	
	@Autowired
	private DemoService demoService;
	
	@Autowired
	private AopService aopService;
	/**
	 * 注解切入
	 */
	@Test
	public void test(){
		demoAnnotationService.add();
	}
	
	
	@Test
	public void test2(){
		demoAnnotationService.aopTest2();
	}
	
	/**
	 * execution 方式切入
	 */
	@Test
	public void test3(){
		demoService.add();
	}
	
	/**
	 * 通过xml 配置
	 */
	@Test
	public void test4(){
		aopService.add();
	}
}
