package com.LeoDuarte37.ForgotPassword_Api.service;

/**
 * <h1>JwtService</h1>
 * <p>
 *     This is an interface that specifies some
 *     methods and how to implement them to
 *     handle with access tokens.
 * </p>
 */
public interface JwtService {

    /**
     * Generate token using username
     *
     * @param username username from login.
     * @return Access token
     */
    String generateToken(String username);

    /**
     * Validates the token and extracts the
     * username from it.
     *
     * @param token token generated by generateToken method.
     * @return username from token
     */
    String verifyToken(String token);
}
