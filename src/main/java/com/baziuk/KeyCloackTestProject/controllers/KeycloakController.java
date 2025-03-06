package com.baziuk.KeyCloackTestProject.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class KeycloakController {

    @GetMapping("/get")
    @PreAuthorize("hasRole('ADMIN')")
    public String get() {
        return "html/test";
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('USER')")
    public String getAll() {
        return "html/testAll";
    }

    @GetMapping("/getAllInfo")
    public String getAlInfo() {
        return "html/testAllInfo";
    }

    @GetMapping("/user")
    public Map<String, Object> getUser(@AuthenticationPrincipal Jwt jwt) {
        return jwt.getClaims();
    }
}
