package com.dgq.spring.context.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AspectDemo {

	@Pointcut("execution(public * com.dgq.spring.context.service.impl.*.*(..))")
	public void aspectMethod() {
		System.out.println("--------");
	}

	@Around("aspectMethod()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		String name = joinPoint.getSignature().getName();

		System.out.println("---------"+name+"方法执行前后");
		final Object result = joinPoint.proceed();
		System.out.println("---------"+name+"方法执行后");

		return result;
	}
}
