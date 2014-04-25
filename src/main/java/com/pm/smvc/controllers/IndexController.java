package com.pm.smvc.controllers;

import com.pm.smvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {

    private int visitorCount;

    @RequestMapping(value = {"/", "/home"})
    public String index(Model model) {
        model.addAttribute("visitorCount", visitorCount++);
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("user", new User("", "", ""));
        return "login_form";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("role") String role,
                          @RequestParam("password") String password,
                          Model model) {
        model.addAttribute("user", new User(name + " is added", role, ""));
        return "login_form";
    }

}
