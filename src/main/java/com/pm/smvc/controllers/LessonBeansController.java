package com.pm.smvc.controllers;

import com.pm.smvc.lessons.beens.PerformanceException;
import com.pm.smvc.lessons.beens.Performer;
import com.pm.smvc.lessons.beens.SingleObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LessonBeansController {

    @Autowired
    @Qualifier("dukePerformer")
    private Performer dukePerformer;

    @Autowired
    @Qualifier("dukePoeticPerformer")
    private Performer dukePoeticPerformer;

    @RequestMapping(value = {"lessons/beans"})
    public String index(Model model) {
        try {
            System.out.println("Duke 1:");
            dukePerformer.perform();
            System.out.println("Duke Poetic 1:");
            dukePoeticPerformer.perform();
            System.out.println("Duke 2:");
            dukePerformer.perform();
            System.out.println("Duke Poetic 2:");
            dukePoeticPerformer.perform();
        } catch (PerformanceException e) {
            e.printStackTrace();
        }
        System.out.println(SingleObject.getInstance().toString());
        return "lessons/beans";
    }

}
