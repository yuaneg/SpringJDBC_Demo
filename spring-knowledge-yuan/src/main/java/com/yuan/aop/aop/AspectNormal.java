package com.yuan.aop.aop;

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
public class AspectNormal {
	
	@Pointcut("execution(* com.yuan.aop.aop..*.*(..))")
	public void point(){
	}
	
	@Before("point()")
	public void before(JoinPoint joinpoint){
		MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
		Method method = methodSignature.getMethod();
		System.out.println("之前执行的方法:被切入的方法名 ="+method.getName());		
	}
	
	@After("point()")
	public void after(JoinPoint joinpoint){
		MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
		Method method = methodSignature.getMethod();
		System.out.println("之后执行的方法:被切入的方法名 ="+method.getName());		
	}
}
