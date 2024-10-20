package com.example.loanorigination.controller;

import com.example.loanorigination.model.AppUser;
import com.example.loanorigination.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    private final AppUserService appUserService;

    @Autowired
    public AdminController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    // Display the admin dashboard
    @GetMapping("/admin/adminDashboard")
    public String showAdminDashboard(Model model) {
        // Add an empty AppUser object for form binding in the view
        model.addAttribute("appUser", new AppUser());
        return "admin/adminDashboard"; // Return the view for the admin dashboard
    }

    // Handle user registration from the admin dashboard
    @PostMapping("/admin/createUser")
    public String createUser(AppUser appUser, Model model) {
        // Register a new user via the service
        appUserService.registerUser(appUser);

        // Add success message or feedback
        model.addAttribute("successMessage", "User created successfully!");

        return "redirect:/admin/adminDashboard";  // Redirect to admin dashboard after user creation
    }
}
