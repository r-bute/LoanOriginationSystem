package com.example.loanorigination.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        String redirectUrl = null;

        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                redirectUrl = "/admin/adminDashboard";
                break;
            } else if (authority.getAuthority().equals("ROLE_MANAGER")) {
                redirectUrl = "/manager/managerDashboard";
                break;
            } else if (authority.getAuthority().equals("ROLE_UNDERWRITER")) {
                redirectUrl = "/underwriter/underwriterDashboard";
                break;
            } else if (authority.getAuthority().equals("ROLE_LOAN_OFFICER")) {
                redirectUrl = "/loan-officer/loanOfficerDashboard";
                break;
            } else if (authority.getAuthority().equals("ROLE_APPUSER")) {
                redirectUrl = "/appUser/appUserDashboard";
                break;
            }
        }

        if (redirectUrl == null) {
            throw new IllegalStateException("User role not recognized");
        }

        response.sendRedirect(redirectUrl);
    }
}
