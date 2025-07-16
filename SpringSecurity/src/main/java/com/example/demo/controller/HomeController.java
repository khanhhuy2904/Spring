package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/default")
    public String handleRedirectAfterLogin(Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("admin"))) {
            return "redirect:/admin/home";
        }
        return "redirect:/user/home";
    }
    
    @GetMapping("/admin/home")
    public String adminHome(Model model, Authentication authentication) {
        String role = authentication.getAuthorities().iterator().next().getAuthority();
        model.addAttribute("role", role);
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "admin-home";
    }

    @GetMapping("/user/home")
    public String userHome(Model model, Authentication authentication) {
        String role = authentication.getAuthorities().iterator().next().getAuthority();
        model.addAttribute("role", role);
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "user-home";
    }
}
