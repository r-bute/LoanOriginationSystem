package com.example.loanorigination.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "app_users")
@Data // Lombok annotation to generate getters, setters, toString, etc.
@NoArgsConstructor // Lombok annotation for the no-argument constructor
@AllArgsConstructor // Lombok annotation for the all-argument constructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;
}