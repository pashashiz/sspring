package com.pm.smvc.lessons.beens;


public class Juggler implements Performer {

    private int beanBags = 3;

    public Juggler() {}

    public Juggler(int beanBags) {
        System.out.println("Creating new Juggler...");
        this.beanBags = beanBags;
    }


    public void setBeanBags(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() throws PerformanceException {
        System.out.println("JUGGLING " + beanBags + " BEANBAGS (Object hashCode: " + hashCode() + ")");
    }
}
