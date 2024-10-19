package com.example.loanorigination.repository;

import com.example.loanorigination.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Custom method to find a user by their username
    Optional<User> findByUsername(String username);
}
