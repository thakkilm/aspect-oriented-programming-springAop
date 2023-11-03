package com.mahesh.learnspringaop.aopexample.peformance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {

	Logger logger=LoggerFactory.getLogger(getClass());
	
	
//	This method will be executed before and after the execution of methods mentioned in the center part of the code
	@Around(("execution(* com.mahesh.learnspringaop.*.*.*.*(..))"))
	  public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		  
		 long startTimesMillies=System.currentTimeMillis();	 
		 
		 Object returnValue=proceedingJoinPoint.proceed();
		 
		 
		 long endTimesMillies=System.currentTimeMillis();	
		 long resultTime=endTimesMillies-startTimesMillies;
		 
		 logger.info("Around Aspect - {} Time teaken for method execution is {}",proceedingJoinPoint,resultTime);
		 return returnValue;
	
	}
}
