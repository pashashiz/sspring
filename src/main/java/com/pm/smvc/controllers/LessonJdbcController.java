package com.pm.smvc.controllers;

import com.pm.smvc.modelJdbc.dao.DaoOldUser;
import com.pm.smvc.modelJdbc.objects.OldUser;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LessonJdbcController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @RequestMapping(value = {"lessons/jdbc/add_random_user"})
    public String addRandomUser(Model model) {
        OldUser oldUser = new OldUser("test_user_" + Math.round(Math.random() * 1000), "ROLE_USER", "psw");
        System.out.println("Start adding oldUser: " + oldUser);
        DaoOldUser daoOldUser = (DaoOldUser) applicationContext.getBean("daoOldUser");
        boolean result = daoOldUser.addUser(oldUser);
        System.out.println("Finish adding oldUser: " + result);
        return "lessons/beans";
    }

    @RequestMapping(value = {"lessons/jdbc/get_user"})
    public String getUserById(@RequestParam("id") int id, Model model) {
        id = (id > 0) ? id : 1;
        System.out.println("Start getting oldUser, id: " + id);
        DaoOldUser daoOldUser = (DaoOldUser) applicationContext.getBean("daoOldUser");
        OldUser oldUser = daoOldUser.getUser(id);
        System.out.println("Finish getting oldUser: " + oldUser);
        return "lessons/beans";
    }

}
