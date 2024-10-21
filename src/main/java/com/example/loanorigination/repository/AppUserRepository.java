package com.example.loanorigination.repository;

import com.example.loanorigination.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;


public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);

    // Method for searching users by username
    List<AppUser> findByUsernameContainingIgnoreCase(String username);

    // Method for pagination
    Page<AppUser> findAll(Pageable pageable);

}
