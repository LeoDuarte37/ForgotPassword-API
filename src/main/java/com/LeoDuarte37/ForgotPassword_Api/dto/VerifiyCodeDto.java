package com.LeoDuarte37.ForgotPassword_Api.dto;

import jakarta.validation.constraints.NotBlank;

public record VerifiyCodeDto(
        @NotBlank
        String username,

        @NotBlank
        String code
    ) {
}
