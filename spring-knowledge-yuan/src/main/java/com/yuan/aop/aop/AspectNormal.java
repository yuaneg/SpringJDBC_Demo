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
	/**
	 * 切入点 execution表达式
	 * 第一部分第一个 * 表示方法 的修饰和返回值  public void ~~ private String 等等
	 * 第二部分是方法的全限定名的包
	 * 第三部分 .. 是指此包和此包下的子包
	 * 第四部分 * 所有的类名
	 * 第五部分的 * 表示所有的方法
	 * 第六部分 (..) 方法的参数
	 */
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
