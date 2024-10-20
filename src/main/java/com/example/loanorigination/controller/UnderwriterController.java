package com.example.loanorigination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnderwriterController {

    @GetMapping("/underwriter/underwriterDashboard")
    public String showUnderwriterDashboard() {
        return "underwriter/underwriterDashboard";  // Path to the underwriter dashboard template
    }
}
