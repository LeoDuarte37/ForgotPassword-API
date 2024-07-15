package com.LeoDuarte37.ForgotPassword_Api.dto;

public record SessionLoginDto(
        String username,
        String role,
        String token
    ) {
}
