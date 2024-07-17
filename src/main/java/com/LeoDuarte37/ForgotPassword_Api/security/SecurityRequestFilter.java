package com.LeoDuarte37.ForgotPassword_Api.security;

import com.LeoDuarte37.ForgotPassword_Api.exception.AuthHeaderNotFoundException;
import com.LeoDuarte37.ForgotPassword_Api.service.impl.JwtServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtServiceImpl jwtServiceImpl;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = extractToken(request);

            var username = jwtServiceImpl.verifyToken(token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );

            SecurityContextHolder.getContext().setAuthentication(authToken);

            filterChain.doFilter(request, response);
        } catch (AuthHeaderNotFoundException | UsernameNotFoundException | ServletException e) {
            System.out.println(e.getMessage());;
        }
    }

    private String extractToken(HttpServletRequest request) throws AuthHeaderNotFoundException {
        var authHeader = request.getHeader("Authorization");

        if (authHeader == null) {
            throw new AuthHeaderNotFoundException("Authorization header can't is null");
        }

        return authHeader.replace("Bearer ", "");
    }
}
