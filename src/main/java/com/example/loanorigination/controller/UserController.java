package com.example.loanorigination.controller;

import com.example.loanorigination.model.User;
import com.example.loanorigination.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Serve the registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());  // Add an empty User object to the form
        return "register";  // Render the registration form (register.html)
    }

    // Handle form submission for user registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        // Save the user
        userService.saveUser(user);

        // Redirect to a success page or login page
        return "redirect:/login";  // Redirect to the login page after successful registration
    }

    @GetMapping("/login")
    public String login() {
        return "login";  // Render the login.html page
    }
}
