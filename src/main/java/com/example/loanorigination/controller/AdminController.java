package com.example.loanorigination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/adminDashboard")
    public String adminDashboard() {
        return "admin/adminDashboard"; // This should match the path of your Thymeleaf template
    }
}
