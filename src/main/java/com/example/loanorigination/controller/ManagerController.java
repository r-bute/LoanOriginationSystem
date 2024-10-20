package com.example.loanorigination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {

    @GetMapping("/manager/managerDashboard")
    public String showManagerDashboard() {
        return "manager/managerDashboard";  // Path to the manager dashboard template
    }
}
