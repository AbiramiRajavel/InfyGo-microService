package com.infy.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingCls {

	public static final Log logger=LogFactory.getLog(LoggingCls.class);
	@Before("execution(* com.infy.Controller.BookingController.*(..))")
	public void controlerlogbefore() {
		logger.info("In Contoller Method..");
	}
	@After("execution(* com.infy.Controller.BookingController.*(..))")
	public void controlerlogbeafter() {
		logger.info("Returned from Controller");
	}
	
    @AfterReturning(pointcut="execution(* com.infy.Service.BookingService.*(..))",returning="retVal")
	public void searchlogafterreturning(JoinPoint jp, Object retVal)
    {
		logger.info("Sucsess message.");
	}
    @Before("execution(* com.infy.Service.BookingService.*(..))")
	public void servicelogbefore() {
		logger.info("In Service Method..");
	}
	@After("execution(* com.infy.Service.BookingService.*(..))")
	public void servicelogbeafter() {
		logger.info("Returned from Service");
	}

    @AfterThrowing(pointcut="execution(* com.infy.Service.BookingService.*(..))",throwing="ex")
   	public void searchlogafterthrowing( JoinPoint joinPoint,Exception ex)
       {
   		logger.error("error meassage throw...!!!"+ex.getMessage());
     	}
}
