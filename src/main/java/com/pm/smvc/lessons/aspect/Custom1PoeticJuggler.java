package com.pm.smvc.lessons.aspect;

import com.pm.smvc.lessons.beens.Poem;
import com.pm.smvc.lessons.beens.PoeticJuggler;

public class Custom1PoeticJuggler extends PoeticJuggler {

    public Custom1PoeticJuggler() {
        super();
    }

    public Custom1PoeticJuggler(Poem poem) {
        super(poem);
    }

    public Custom1PoeticJuggler(int beanBags, Poem poem) {
        super(beanBags, poem);
    }
}
