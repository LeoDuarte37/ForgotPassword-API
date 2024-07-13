package com.LeoDuarte37.ForgotPassword_Api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

//    @NotNull
//    @Enumerated(EnumType.STRING)
//    private Perfil perfil;

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

//    public Perfil getPerfil() {
//        return perfil;
//    }
//
//    public void setPerfil(Perfil perfil) {
//        this.perfil = perfil;
//    }
}
