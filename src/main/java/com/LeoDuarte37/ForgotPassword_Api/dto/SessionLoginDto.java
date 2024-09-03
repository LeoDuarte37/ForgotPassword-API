package com.LeoDuarte37.ForgotPassword_Api.dto;

/**
 * DTO to response successful login
 *
 * @param username username from login.
 * @param role role from login.
 * @param token previously generated token.
 */
public record SessionLoginDto(
        String username,
        String role,
        String token
    ) {
}
