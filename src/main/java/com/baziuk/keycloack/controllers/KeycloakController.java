package com.baziuk.keycloack.controllers;

import com.baziuk.keycloack.security.SecurityConfig;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KeycloakController {
    @GetMapping("/hello")
    @RolesAllowed("ROLE_ADMIN")
    public String hello(){
        return "/html/hello";
    }

    @GetMapping("/get")
    @RolesAllowed("ROLE_ADMIN")
    public String get() {
        return "/html/test";
    }

    @GetMapping("/")
    public String getStart(Model model) {
        model.addAttribute("fullname", SecurityConfig.fullName());
        return "html/test";
    }

    @GetMapping("/getAll")
    @RolesAllowed("ROLE_MANAGER")
    public String getAll() {
        return "html/testAll";
    }

    @GetMapping("/getAllInfo")
    @RolesAllowed("ROLE_USER")
    public String getAlInfo() {
        return "html/testAllInfo";
    }

    @GetMapping("/registration")
    public String registration() {
        return "html/registration";
    }

}
