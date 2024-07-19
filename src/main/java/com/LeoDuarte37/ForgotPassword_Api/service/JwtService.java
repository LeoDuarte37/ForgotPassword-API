package com.LeoDuarte37.ForgotPassword_Api.service;

public interface JwtService {

    String generateToken(String username);
    String verifyToken(String token);
}
