package com.mahesh.learnspringaop.aopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	
//	Executed after the throwed any exception. Executes this method twice before and after the execution of the exception method
	@AfterThrowing(pointcut = "execution(* com.mahesh.learnspringaop.*.*.*.*(..))",
			throwing = "exception")
	public void logMethodCallAfterThrowingException(JoinPoint joinPoint,Exception exception) {
		logger.info("AfterThrowing Aspect -{} method exception {}", joinPoint,exception);
	}
	
//	Executed after the method is successfully executed or throwed any exception. It returns the return value of any methods specified in the package classes
	@AfterReturning(pointcut = "execution(* com.mahesh.learnspringaop.*.*.*.*(..))",
			returning = "result")
	public void logMethodCallAfterThrowingException(JoinPoint joinPoint,Object result) {
		logger.info("@AfterReturning Aspect -{} method retuen Values {}", joinPoint,result);
	}
	
}
