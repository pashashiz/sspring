package com.pm.smvc.lessons.beens;

public class SingleObject {

    private static SingleObject instance;

    private SingleObject() {}

    public static SingleObject getInstance() {
        if (instance == null)
            synchronized (SingleObject.class) {
                instance = new SingleObject();
            }
        return instance;
    }

    public String toString() {
        return "Single Object (Object hashCode: " + hashCode() + ")";
    }

}
