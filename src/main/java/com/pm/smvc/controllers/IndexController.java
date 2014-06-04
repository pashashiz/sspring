package com.pm.smvc.controllers;

import com.pm.smvc.modelJdbc.objects.OldUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.InitialContext;
import javax.naming.NamingException;


@Controller
public class IndexController {

    private int visitorCount;

    @RequestMapping(value = {"/", "/home"})
    public String index(Model model) {
        model.addAttribute("visitorCount", visitorCount++);
        try {
            InitialContext ic = new InitialContext();
            System.out.println("Data source: " + ic.lookup("java:/DefaultDS"));
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("user", new OldUser("", "", ""));
        return "login_form";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("role") String role,
                          @RequestParam("password") String password,
                          Model model) {
        model.addAttribute("user", new OldUser(name + " is added", role, ""));
        return "login_form";
    }

}
