package com.bogurov.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeLoggingAspect {
    private static final Logger log = Logger.getLogger(EmployeeLoggingAspect.class);

    @Around("execution(* com.bogurov.dao.*.*(..))") //any class and method with any parameters
    public Object aroundAllRepositoryMethodAdvice(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature =
                (MethodSignature) proceedingJoinPoint.getSignature();

        String methodName = methodSignature.getName();

        Object targetMethodResult = proceedingJoinPoint.proceed();
        log.info("Successfully execute " + methodName);
        return targetMethodResult;

    }
}
