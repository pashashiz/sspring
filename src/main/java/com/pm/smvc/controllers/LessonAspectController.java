package com.pm.smvc.controllers;

import com.pm.smvc.lessons.aspect.Human;
import com.pm.smvc.lessons.beens.PerformanceException;
import com.pm.smvc.lessons.beens.Performer;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LessonAspectController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @RequestMapping(value = {"lessons/aspect/xml/base"})
    public String xmlBase(Model model) {
        try {
            System.out.println("Henry Poetic :");
            Performer henry = (Performer) applicationContext.getBean("henryPoeticPerformer");
            Human human = (Human) applicationContext.getBean("henryPoeticPerformer");
            System.out.println("Name: " + (human.getName()));
            henry.perform();
        } catch (PerformanceException e) {
            e.printStackTrace();
        }
        return "lessons/beans";
    }

    @RequestMapping(value = {"lessons/aspect/annotations/base"})
    public String xmlAnnotationsBase(Model model) {
        try {
            System.out.println("Bob Poetic :");
            Performer henry = (Performer) applicationContext.getBean("bobPoeticPerformer");
            henry.perform();
        } catch (PerformanceException e) {
            e.printStackTrace();
        }
        return "lessons/beans";
    }

}
