package com.example.loanorigination.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

    private final AuthenticationSuccessHandler customAuthenticationSuccessHandler;

    public SecurityConfig(CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // BCrypt for password encoding
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/login", "/about", "/contact","/error", "/css/**", "/js/**").permitAll()  // Allow public access to these pages
                        .requestMatchers("/admin/**").hasRole("ADMIN")  // Only ADMIN can access /admin
                        .requestMatchers("/manager/**").hasRole("MANAGER")  // Only MANAGER can access /manager
                        .requestMatchers("/underwriter/**").hasRole("UNDERWRITER")  // Only UNDERWRITER can access /underwriter
                        .requestMatchers("/loan-officer/**").hasRole("LOAN_OFFICER")  // Only LOAN_OFFICER can access /loan-officer
                        .requestMatchers("/appUser/**").hasRole("APPUSER")  // Only APPUSER can access /appUser
                        .anyRequest().authenticated()  // All other requests need authentication
                )
                .formLogin((form) -> form
                        .loginPage("/login")  // Custom login page
                        .successHandler(customAuthenticationSuccessHandler)  // Use custom success handler
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/login?logout")  // Redirect to login with logout query parameter
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable());  // Disable CSRF protection for development/testing; re-enable in production

        return http.build();
    }
}
