package com.example.loanorigination.controller;

import com.example.loanorigination.model.AppUser;
import com.example.loanorigination.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

    private final AppUserService appUserService;

    @Autowired
    public AdminController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    // Admin Dashboard: Display all users
    @GetMapping("/admin/adminDashboard")
    public String showAdminDashboard(Model model) {
        List<AppUser> users = appUserService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/adminDashboard";
    }

    // Display edit user form
    @GetMapping("/admin/editUser/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        Optional<AppUser> userOptional = appUserService.getUserById(id);
        if (userOptional.isPresent()) {
            model.addAttribute("appUser", userOptional.get());
            return "admin/editUser";
        } else {
            return "redirect:/error";  // Custom error page if user ID not found
        }
    }

    // Handle user update
    @PostMapping("/admin/updateUser/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("appUser") AppUser updatedUser) {
        appUserService.updateUser(id, updatedUser);
        return "redirect:/admin/adminDashboard";
    }

    // Handle user deletion
    @GetMapping("/admin/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        appUserService.deleteUser(id);
        return "redirect:/admin/adminDashboard";
    }

    // Toggle freeze/unfreeze status
    @GetMapping("/admin/freezeUser/{id}")
    public String toggleUserStatus(@PathVariable Long id) {
        appUserService.toggleUserStatus(id);
        return "redirect:/admin/adminDashboard";
    }

    // Search users by username
    @GetMapping("/admin/search")
    public String searchUsers(@RequestParam("query") String query, Model model) {
        List<AppUser> searchResults = appUserService.searchUsersByUsername(query);
        model.addAttribute("users", searchResults);
        return "admin/adminDashboard";
    }

    // Pagination
    @GetMapping("/admin/users")
    public String listUsersPaginated(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            Model model) {

        Page<AppUser> usersPage = appUserService.getUsersPaginated(page, size);
        model.addAttribute("users", usersPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", usersPage.getTotalPages());
        return "admin/adminDashboard";
    }

    // Display the register page
    @GetMapping("/admin/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("appUser", new AppUser());  // Add an empty AppUser object to the model
        return "admin/register";  // Return the correct path to your register template
    }

    @PostMapping("/admin/register")
    public String registerUser(@ModelAttribute("appUser") AppUser appUser) {
        appUserService.registerUser(appUser);
        return "redirect:/admin/adminDashboard";
    }




}
