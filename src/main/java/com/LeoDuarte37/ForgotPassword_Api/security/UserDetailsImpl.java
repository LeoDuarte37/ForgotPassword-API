package com.LeoDuarte37.ForgotPassword_Api.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private List<SimpleGrantedAuthority> authorities;

    public UserDetailsImpl(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authorities = List.of(new SimpleGrantedAuthority(authority));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
