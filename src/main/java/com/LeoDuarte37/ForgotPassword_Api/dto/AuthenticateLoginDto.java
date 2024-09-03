package com.LeoDuarte37.ForgotPassword_Api.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO for authentication requests.
 *
 * @param username username from login.
 * @param password password from login.
 */
public record AuthenticateLoginDto(
        @NotBlank
        String username,

        @NotBlank
        String password
    ) {
}
