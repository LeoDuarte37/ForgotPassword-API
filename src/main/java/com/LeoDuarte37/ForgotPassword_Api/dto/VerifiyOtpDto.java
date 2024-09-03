package com.LeoDuarte37.ForgotPassword_Api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO to request verification code generated
 * by two-factor authentication
 *
 * @param username username from login.
 * @param otp previously generated otp code.
 */
public record VerifiyOtpDto(
        @NotBlank
        String username,

        @NotNull
        Integer otp
    ) {
}
