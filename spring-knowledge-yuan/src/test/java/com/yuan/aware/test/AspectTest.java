package com.yuan.aware.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuan.aop.annotationaop.DemoAnnotationService;
import com.yuan.aop.aop.DemoService;
import com.yuan.aop.aopxml.AopService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class AspectTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AspectTest.class);
	
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
	public void testAnnotation1(){
		demoAnnotationService.add();
		logger.info("注解切入");
	}
	
	
	@Test
	public void testAnnotation2(){
		demoAnnotationService.aopTest2();
		logger.info("注解切入2");
	}
	
	/**
	 * execution 方式切入
	 */
	@Test
	public void testExecution(){
		demoService.add();
		logger.info("普通execution方式");
	}
	
	/**
	 * 通过xml 配置
	 */
	@Test
	public void testXmlAop(){
		aopService.add();
		logger.info("xml配置");
	}
}
