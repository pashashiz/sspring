package com.pm.smvc.lessons.aspect;

import com.pm.smvc.lessons.beens.Poem;
import com.pm.smvc.lessons.beens.PoeticJuggler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

@Component("beanPoeticJuggler")
public class BeanPoeticJuggler extends PoeticJuggler {

    public BeanPoeticJuggler() {
        super();
    }

    @Inject
    @Override
    public void setPoem(@Named("sonnet116") Poem poem) {
        super.setPoem(poem);
    }

    @Inject
    @Override
    public void setBeanBags(@Value("7") int beanBags) {
        super.setBeanBags(beanBags);
    }
}
