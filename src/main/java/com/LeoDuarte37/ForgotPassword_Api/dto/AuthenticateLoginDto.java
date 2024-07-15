package com.LeoDuarte37.ForgotPassword_Api.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticateLoginDto(
        @NotBlank
        String username,

        @NotBlank
        String password
    ) {
}
