package com.LeoDuarte37.ForgotPassword_Api.dto;

import com.LeoDuarte37.ForgotPassword_Api.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO to request login registration
 *
 * @param username username for new login/account.
 * @param password password for new login/account.
 * @param user user object for new login/account.
 * @param role role for new login/account.
 */
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
