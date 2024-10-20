package com.example.loanorigination.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app_users")
@Data // Lombok annotation to generate getters, setters, toString, etc.
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)  // Store roles as strings in the database
    @Column(nullable = false)
    private Role role;

    // Enum for different roles
    public enum Role {
        APPUSER,
        LOAN_OFFICER,
        MANAGER,
        UNDERWRITER,
        ADMIN
    }
}
