package com.example.java_spring_sem8_hometask_ex02.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingActionsAspect {

    private final Logger logger = Logger.getLogger(LoggingActionsAspect.class.getName());

    @Before("@annotation(LogActions)")
    public void logActions(JoinPoint joinPoint){
        String user = "currentUser";

        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("User " + user + " invoked " + methodName + " with arguments: " + Arrays.toString(args));
    }
}
