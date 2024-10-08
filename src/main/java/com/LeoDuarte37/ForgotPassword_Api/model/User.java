package com.LeoDuarte37.ForgotPassword_Api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/**
 * <h1>User</h1>
 * <p>
 *     This class contains basic information
 *     about a user.
 * </p>
 *
 * @author Leonardo
 * @version 1.0
 */
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
