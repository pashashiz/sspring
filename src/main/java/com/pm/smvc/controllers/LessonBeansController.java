package com.pm.smvc.controllers;

import com.pm.smvc.lessons.beens.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.inject.Named;


@Controller
public class LessonBeansController implements BeanNameAware, ApplicationContextAware {

    private String beanName;
    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Autowired
    @Qualifier("dukePerformer")
    private Performer dukePerformer;

    @Autowired
    @Qualifier("dukePoeticPerformer")
    private Performer dukePoeticPerformer;

    @Autowired
    @Qualifier("mikePoeticPerformer")
    private Performer mikePoeticPerformer;

    @Autowired
    @Qualifier("benPoeticPerformer")
    private Performer benPoeticPerformer;

    @Autowired
    @Qualifier("robPoeticPerformer")
    private Performer robPoeticPerformer;

    @Autowired
    @Qualifier("stivPoeticPerformer")
    private PoeticJuggler stivPoeticPerformer;

    @Inject
    @Named("joePoeticPerformer")
    private PoeticJuggler joePoeticPerformer;


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
            System.out.println("Mike Poetic 1:");
            mikePoeticPerformer.perform();
        } catch (PerformanceException e) {
            e.printStackTrace();
        }
        System.out.println(SingleObject.getInstance().toString());
        return "lessons/beans";
    }

    @RequestMapping(value = {"lessons/beans/binding_components"})
    public String bindingComponents(Model model) {
        try {
            System.out.println("Ben Poetic:");
            benPoeticPerformer.perform();
            System.out.println("Rob Poetic:");
            robPoeticPerformer.perform();
        } catch (PerformanceException e) {
            e.printStackTrace();
        }
        return "lessons/beans";
    }

    @RequestMapping(value = {"lessons/beans/replacing_method"})
    public String replacingMethod(Model model) {
        try {
            System.out.println("Stiv Poetic (proffesion: " + stivPoeticPerformer.getProfession() + "):");
            stivPoeticPerformer.perform();
        } catch (PerformanceException e) {
            e.printStackTrace();
        }
        return "lessons/beans";
    }

    @RequestMapping(value = {"lessons/beans/inject_get_method"})
    public String injectGetMethod(Model model) {
        try {
            System.out.println("Joe Poetic :");
            joePoeticPerformer.perform();
            System.out.println("get Poem :" + joePoeticPerformer.getPoem());
        } catch (PerformanceException e) {
            e.printStackTrace();
        }
        return "lessons/beans";
    }

    @RequestMapping(value = {"lessons/beans/application_context"})
    public String applicationContext(Model model) {
        System.out.println("Bean name: " + beanName);
        System.out.println("Application context: " + applicationContext);
        return "lessons/beans";
    }

}
