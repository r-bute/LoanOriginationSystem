package com.example.loanorigination.service;

import com.example.loanorigination.model.User;
import com.example.loanorigination.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Method to save a new user with encoded password
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt the password
        return userRepository.save(user);
    }

    // Method to find user by username
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Additional methods for user management to be added here
}
