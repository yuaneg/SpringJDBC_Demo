package com.yuan.aop.annotationaop;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {
	
	@Pointcut("@annotation(com.yuan.aop.annotationaop.AnnotationAspect)")
	public void annotationPointCut() {
	}
	
	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint){
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		AnnotationAspect annotationAspect = method.getAnnotation(AnnotationAspect.class);
		System.out.println("后执行的方法:注解内容 = "+annotationAspect.name());
	}
	
	@Before("annotationPointCut()")
	public void before(JoinPoint joinPoint){
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		AnnotationAspect annotationAspect = method.getAnnotation(AnnotationAspect.class);
		System.out.println("前执行的方法:注解内容 = "+annotationAspect.name());
	}
	
}
