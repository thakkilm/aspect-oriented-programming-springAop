package com.mahesh.learnspringaop.aopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	
//	Executes before method is called
	@Before("execution(* com.mahesh.learnspringaop.*.*.*.*(..))")
	public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
		logger.info("Before Aspect - Method called is {}",joinPoint);
	}
	
//	Executed after the method is successfully executed or throwed any exception
	@After("execution(* com.mahesh.learnspringaop.*.*.*.*(..))")
	public void logMethodCallAfterExecution(JoinPoint joinPoint) {
		logger.info("After Aspect -{} method argumenmts {}", joinPoint,joinPoint.getArgs());
	}
	
}
