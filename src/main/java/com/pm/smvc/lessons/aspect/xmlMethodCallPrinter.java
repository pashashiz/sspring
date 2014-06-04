package com.pm.smvc.lessons.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class xmlMethodCallPrinter {

    public void callAround(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Call around (before)...");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Call around (after)...");
    }

    public void callBefore() {
        System.out.println("Call before...");
    }

    public void callAfter() {
        System.out.println("Call after (always)...");
    }

    public void callAfterReturning() {
        System.out.println("Call after returning...");
    }

    public void callAfterThrowing() {
        System.out.println("Call after throwing...");
    }

}
