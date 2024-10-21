package com.example.loanorigination.controller;

import com.example.loanorigination.model.AppUser;
import com.example.loanorigination.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appUser")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    // Process the registration form submission
    @PostMapping("/register")
    public String registerUser(AppUser appUser) {
        appUserService.registerUser(appUser);
        return "redirect:/login";  // Redirect to login after successful registration
    }

    // Display the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Thymeleaf template for login page
    }

    // Dashboard for app users after login
    @GetMapping("/dashboard")
    public String showAppUserDashboard() {
        return "appUser/appUserDashboard";  // Redirect to the app user dashboard page
    }
}
