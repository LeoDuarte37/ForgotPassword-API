package com.LeoDuarte37.ForgotPassword_Api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VerifiyOtpDto(
        @NotBlank
        String username,

        @NotNull
        Integer otp
    ) {
}
