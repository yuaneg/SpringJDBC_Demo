package com.yuan.aop.annotationaop;

import org.springframework.stereotype.Component;

/**
 * 这种方式下只要通过 @AnnotationAspect 注解的方法就会被加入切面 灵活性大 
 * @author yuaneg
 *
 */
@Component
public class DemoAnnotationService {
	
	/**
	 * 被注解的方法
	 */
	@AnnotationAspect(name="注解式拦截方法1")
	public void add(){
		System.out.println("我是方法1");
	}
	
	@AnnotationAspect(name="注解式拦截方法2")
	public void aopTest2(){
		System.out.println("我是方法2");
	}
}
