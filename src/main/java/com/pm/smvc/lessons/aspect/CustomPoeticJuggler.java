package com.pm.smvc.lessons.aspect;

import com.pm.smvc.lessons.beens.Poem;
import com.pm.smvc.lessons.beens.PoeticJuggler;

public class CustomPoeticJuggler extends PoeticJuggler {

    public CustomPoeticJuggler() {
        super();
    }

    public CustomPoeticJuggler(Poem poem) {
        super(poem);
    }

    public CustomPoeticJuggler(int beanBags, Poem poem) {
        super(beanBags, poem);
    }
}
