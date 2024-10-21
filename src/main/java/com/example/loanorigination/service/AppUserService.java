package com.example.loanorigination.service;

import com.example.loanorigination.model.AppUser;
import com.example.loanorigination.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Register a new user
    public void registerUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));  // Encode password before saving
        appUserRepository.save(appUser);  // Save user to the database
    }

    // Retrieve all users
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    // Get paginated users
    public Page<AppUser> getUsersPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return appUserRepository.findAll(pageable);
    }

    // Search users by username (case-insensitive and partial matching)
    public List<AppUser> searchUsersByUsername(String username) {
        return appUserRepository.findByUsernameContainingIgnoreCase(username);
    }

    // Find a user by ID
    public Optional<AppUser> getUserById(Long id) {
        return appUserRepository.findById(id);
    }

    // Edit a user's details
    public void updateUser(Long id, AppUser updatedUser) {
        Optional<AppUser> userOptional = appUserRepository.findById(id);
        if (userOptional.isPresent()) {
            AppUser existingUser = userOptional.get();
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setRole(updatedUser.getRole());
            // Optionally re-encode password if it's being updated
            if (!updatedUser.getPassword().isEmpty()) {
                existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            }
            appUserRepository.save(existingUser);
        }
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        appUserRepository.deleteById(id);
    }

    // Freeze or unfreeze a user account (toggle active status)
    public void toggleUserStatus(Long id) {
        Optional<AppUser> userOptional = appUserRepository.findById(id);
        if (userOptional.isPresent()) {
            AppUser existingUser = userOptional.get();
            existingUser.setActive(!existingUser.isActive());  // Toggle active status
            appUserRepository.save(existingUser);
        }
    }
}
