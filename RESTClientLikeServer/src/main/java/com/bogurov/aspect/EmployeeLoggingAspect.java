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

    @Around("execution(* com.bogurov..*.*(..))") //any class and method with any parameters
    public Object aroundAllRepositoryMethodAdvice(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature =
                (MethodSignature) proceedingJoinPoint.getSignature();

        /*
        *       Some code before executing the method
        * */

        Object targetMethodResult = proceedingJoinPoint.proceed();

        /*
         *       Some code after executing the method
         * */

        String methodName = methodSignature.getName();
        log.info("Successfully execute " + methodName);
        return targetMethodResult;

    }
}
