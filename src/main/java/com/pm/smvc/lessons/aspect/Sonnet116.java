package com.pm.smvc.lessons.aspect;

import com.pm.smvc.lessons.beens.Poem;
import org.springframework.stereotype.Component;

@Component("sonnet116")
public class Sonnet116 implements Poem {

    private static String[] LINES = {
            "Let me not to the marriage of true minds",
            "Admit impediments. Love is not love ..."
    };

    @Override
    public void recite() {
        for (String line: LINES)
            System.out.println(line);
    }
}
