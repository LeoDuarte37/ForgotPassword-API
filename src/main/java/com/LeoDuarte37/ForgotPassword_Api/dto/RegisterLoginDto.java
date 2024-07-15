package com.LeoDuarte37.ForgotPassword_Api.dto;

import com.LeoDuarte37.ForgotPassword_Api.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterLoginDto(
        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotNull
        User user,

        @NotNull
        int role
    ) {
}
