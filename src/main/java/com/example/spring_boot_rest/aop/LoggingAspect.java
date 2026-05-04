package com.example.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.spring_boot_rest.service.JobService.getAllJobs(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called " + jp.getSignature().getName());
    }

    @After("execution(* com.example.spring_boot_rest.service.JobService.getAllJobs(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.example.spring_boot_rest.service.JobService.getAllJobs(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method Crashed " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.spring_boot_rest.service.JobService.getAllJobs(..))")
    public void logMethodSuccessfullyExecuting(JoinPoint jp){
        LOGGER.info("Method Successfully Executed " + jp.getSignature().getName());
    }
    
}
