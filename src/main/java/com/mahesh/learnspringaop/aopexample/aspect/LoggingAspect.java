package com.mahesh.learnspringaop.aopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	
	
	@Before("execution(* com.mahesh.learnspringaop.*.*.*.*(..))")
	public void logMethodCall(JoinPoint joinPoint) {
		logger.info("Before Aspect - Method called is {}",joinPoint);
	}
	
	
}
