package com.LeoDuarte37.ForgotPassword_Api.model;

import com.LeoDuarte37.ForgotPassword_Api.enumeration.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * <h1>Login</h1>
 * <p>
 *     This class contains the main attributes
 *     to perform user authentication.
 * </p>
 *
 * @author Leonardo
 * @version 1.0
 */
@Entity
@Table(name = "tb_login")
public class Login {

    @Id
    private String username;

    @NotBlank
    private String password;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL, CascadeType.PERSIST }, orphanRemoval = true)
    private User user;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    public Login(String username, String password, User user, Role role) {
        this.username = username;
        this.password = password;
        this.user = user;
        this.role = role;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
