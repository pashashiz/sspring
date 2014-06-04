package com.pm.smvc.controllers;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AuthController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model) {

        return "login_form";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String authorization(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
        String role = "ROLE_ADMIN";
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role));
        System.out.println("AUTHORIZATION: {login: " + name + ", password: " + password + "}");
        Authentication authentication = new UsernamePasswordAuthenticationToken(name, password, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/admin";
    }


}
