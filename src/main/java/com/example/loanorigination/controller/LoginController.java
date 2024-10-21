package com.example.loanorigination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // Display the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Thymeleaf template for login page
    }
}
