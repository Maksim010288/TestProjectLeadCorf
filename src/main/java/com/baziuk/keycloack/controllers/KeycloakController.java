package com.baziuk.keycloack.controllers;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KeycloakController {

    @GetMapping("/get")
    @RolesAllowed("ROLE_ADMIN")
    public String get() {
        return "/html/test";
    }

    @GetMapping("/")
    @RolesAllowed("ROLE_ADMIN")
    public String getStart() {
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

}
