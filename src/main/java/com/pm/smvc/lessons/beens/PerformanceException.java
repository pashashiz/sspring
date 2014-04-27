package com.pm.smvc.lessons.beens;

public class PerformanceException extends Exception {

    public PerformanceException() {
        super();
    }

    public PerformanceException(String s) {
        super(s);
    }

    public PerformanceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public PerformanceException(Throwable throwable) {
        super(throwable);
    }

    protected PerformanceException(String s, Throwable throwable, boolean b, boolean b2) {
        super(s, throwable, b, b2);
    }
}
