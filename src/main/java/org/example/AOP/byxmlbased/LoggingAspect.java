package org.example.AOP.byxmlbased;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class LoggingAspect {

    public void sayHelloPoincut() {}

    // Before Advice
    public void logBefore() {
        System.out.println("Logging before sayHello()");
    }

    //After Advice
    public void logAfter() {
        System.out.println("Logging after sayHello()");
    }

    //Around Advice
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around - Before Starting method: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("Around - After method: " + joinPoint.getSignature().getName());
        return result;
    }
}
