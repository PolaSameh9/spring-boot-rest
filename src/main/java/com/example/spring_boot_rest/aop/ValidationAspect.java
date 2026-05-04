package com.example.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {


    public static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.example.spring_boot_rest.service.JobService.getJob(..)) && args(postId)")
    public Object logMethodCall(ProceedingJoinPoint jp, int postId) throws Throwable{

        if(postId < 0){
            LOGGER.info("Post id is negative, Updating it...");
            postId = -postId;
            LOGGER.info("New value is: " + postId);
        }

        Object obj = jp.proceed(new Object[]{postId});
        
        return obj;
    }


}
