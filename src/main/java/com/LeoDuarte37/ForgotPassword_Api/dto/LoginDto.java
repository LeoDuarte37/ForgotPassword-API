package com.LeoDuarte37.ForgotPassword_Api.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDto(
        @NotBlank
        String username,

        @NotBlank
        String password
    ) {
}
