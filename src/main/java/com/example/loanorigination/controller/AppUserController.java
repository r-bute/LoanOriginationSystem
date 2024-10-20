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

    // Admin dashboard
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin/adminDashboard";  // Looks in templates/admin/adminDashboard.html
    }

    // Loan Officer dashboard
    @GetMapping("/loan-officer/dashboard")
    public String loanOfficerDashboard() {
        return "loan-officer/loanOfficerDashboard";  // Looks in templates/loan-officer/loanOfficerDashboard.html
    }

    // Manager dashboard
    @GetMapping("/manager/dashboard")
    public String managerDashboard() {
        return "manager/managerDashboard";  // Looks in templates/manager/managerDashboard.html
    }

    // Underwriter dashboard
    @GetMapping("/underwriter/dashboard")
    public String underwriterDashboard() {
        return "underwriter/underwriterDashboard";  // Looks in templates/underwriter/underwriterDashboard.html
    }

    // AppUser dashboard
    @GetMapping("/appUser/dashboard")
    public String appUserDashboard() {
        return "appUser/appUserDashboard";  // Update this to match the renamed file
    }



}
