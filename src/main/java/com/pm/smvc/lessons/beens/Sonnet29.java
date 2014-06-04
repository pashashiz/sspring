package com.pm.smvc.lessons.beens;

public class Sonnet29 implements Poem {

    private static String[] LINES = {
            "When in disgrace with Fortune and men's eyes,",
            "I all alone beweep my outcast state, ..."
    };

    @Override
    public void recite() {
        for (String line: LINES)
            System.out.println(line);
    }
}
