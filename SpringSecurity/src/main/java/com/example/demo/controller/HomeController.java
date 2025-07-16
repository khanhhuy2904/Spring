package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/default")
    public String defaultAfterLogin(Authentication authentication) {
        if (authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin/home";
        }
        return "redirect:/user/home";
    }
    
    @GetMapping("/admin/home")
    public String adminHome() {
        return "admin-home";
    }

    @GetMapping("/user/home")
    public String userHome() {
        return "user-home";
    }
}
