package com.example.loanorigination.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app_users")
@Data  // Lombok will generate getters, setters, toString, etc.
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private boolean active = true;  // Add active status field

    // Enum for roles
    public enum Role {
        APPUSER,
        LOAN_OFFICER,
        MANAGER,
        UNDERWRITER,
        ADMIN
    }
}
