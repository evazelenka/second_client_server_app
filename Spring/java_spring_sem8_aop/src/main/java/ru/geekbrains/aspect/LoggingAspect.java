package ru.geekbrains.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import ru.geekbrains.model.Comment;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Order(2)
    @Around("execution(* ru.geekbrains.service.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{

        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

//        System.out.println("Method will execute");
        System.out.println("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                "will execute");

        Comment comment = new Comment();
        comment.setAuthor("Dima");
        comment.setText("Some other text!");
        Object[] newArgs = {comment};
        Object returnedByMethod = joinPoint.proceed(newArgs);
        System.out.println("Method executed");
        return returnedByMethod;
    }

    @Order(1)
    @Around("execution(* ru.geekbrains.service.*.*(..))")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("start");
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Method " + joinPoint.getSignature().getName() + " - " + elapsedTime+ "ms");
        return result;
    }

    @AfterReturning(value = "@annotation(ToLog)", returning = "returnedValue")
    public void log(Object returnedValue){
        logger.info("Method executed and returned " + returnedValue);
    }
}
