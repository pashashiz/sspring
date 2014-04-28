package com.pm.smvc.lessons.beens;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class ProfesionReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        return "Replace profession for object: " + o;
    }
}
