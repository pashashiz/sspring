package com.pm.smvc.lessons.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class annotationsMethodCallPrinter {

    @Pointcut("execution(* com.pm.smvc.lessons.aspect.CustomPoeticJuggler.perform())")
    public void points() {}

    public void callAround(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Call around (before)...");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Call around (after)...");
    }

    @Before("points()")
    public void callBefore() {
        System.out.println("Call before...");
    }

    @After("points()")
    public void callAfter() {
        System.out.println("Call after (always)...");
    }

    @AfterReturning("points()")
    public void callAfterReturning() {
        System.out.println("Call after returning...");
    }

    @AfterThrowing("points()")
    public void callAfterThrowing() {
        System.out.println("Call after throwing...");
    }

}
