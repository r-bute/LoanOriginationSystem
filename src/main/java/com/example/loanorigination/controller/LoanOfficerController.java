package com.example.loanorigination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoanOfficerController {

    @GetMapping("/loan-officer/loanOfficerDashboard")
    public String showLoanOfficerDashboard() {
        return "loan-officer/loanOfficerDashboard";  // Path to the loan officer dashboard template
    }
}
