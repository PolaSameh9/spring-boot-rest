package com.example.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
@Aspect
public class PerformanceMonitorAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.example.spring_boot_rest.service.JobService.getAllJobs(..))")
    public Object logMethodCall(ProceedingJoinPoint jp) throws Throwable{
        long start = System.currentTimeMillis();
        
        Object obj = jp.proceed();

        long end = System.currentTimeMillis();  

        LOGGER.info("Time taken: " + (end - start) + " ms");

        return obj;
    }

}
