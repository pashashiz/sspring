package com.pm.smvc.lessons.beens;

public class Sonnet18 implements Poem {

    private static String[] LINES = {
            "Shall I compare thee to a summer's day?",
            "Thou art more lovely and more temperate ..."
    };

    @Override
    public void recite() {
        for (String line: LINES)
            System.out.println(line);
    }
}
