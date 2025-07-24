package org.example.AOP.byannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // Poincut tái sử dụng
    @Pointcut("execution(* org.example.AOP.byannotation.MyService.sayHello(..))")
    public void sayHelloPoincut() {}

    // Before Advice
    @Before("sayHelloPoincut()")
    public void logBefore() {
        System.out.println("Logging before sayHello()");
    }

    //After Advice
    @After("sayHelloPoincut()")
    public void logAfter() {
        System.out.println("Logging after sayHello()");
    }

    //Around Advice
    @Around("sayHelloPoincut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around - Before Starting method: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("Around - After method: " + joinPoint.getSignature().getName());
        return result;
    }
}
