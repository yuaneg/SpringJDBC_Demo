package com.yuan.aop.annotationaop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 通过自定义注解的方式配置aop
 * @author yuaneg
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME	)
@Documented
public @interface AnnotationAspect {
	String name() ;
}
