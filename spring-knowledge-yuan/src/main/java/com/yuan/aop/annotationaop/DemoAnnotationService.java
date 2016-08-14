package com.yuan.aop.annotationaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 这种方式下只要通过 @AnnotationAspect 注解的方法就会被加入切面 灵活性大 
 * @author yuaneg
 *
 */
@Component
public class DemoAnnotationService {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoAnnotationService.class);
	
	/**
	 * 被注解的方法
	 */
	@AnnotationAspect(name="注解式拦截方法1")
	public void add(){
		logger.info("我是方法1");
		System.out.println("我是方法1");
	}
	
	@AnnotationAspect(name="注解式拦截方法2")
	public void aopTest2(){
		logger.info("我是方法2");
		System.out.println("我是方法2");
	}
}
