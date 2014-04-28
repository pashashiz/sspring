package com.pm.smvc.lessons.beens;

public class PoeticJuggler extends Juggler {

    private Poem poem;

    public PoeticJuggler() {}

    public PoeticJuggler(Poem poem) {
        super();
        this.poem = poem;
    }

    public PoeticJuggler(int beanBags, Poem poem) {
        super(beanBags);
        System.out.println("Creating new PoeticJuggler...");
        this.poem = poem;
    }

    public void setPoem(Poem poem) {
        this.poem = poem;
    }

    @Override
    public void perform() throws PerformanceException {
        super.perform();
        System.out.println("Poem is: ");
        poem.recite();
    }

    public String getProfession() {
        return "PoeticJuggler";
    }

    public Poem getPoem() {
        return poem;
    }
}
