package com.example.loanorigination.controller;

import com.example.loanorigination.model.AppUser;
import com.example.loanorigination.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("appUser", new AppUser());  // Add AppUser object to the model
        return "register";  // Return the register.html view
    }

    @PostMapping("/register")
    public String registerUser(AppUser appUser) {
        appUserService.registerUser(appUser);  // Service layer to handle user registration
        return "redirect:/login";  // Redirect to login after successful registration
    }

    @GetMapping("/login")
    public String login() {
        return "login";  // Return the login page
    }
}
