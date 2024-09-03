package com.LeoDuarte37.ForgotPassword_Api.service;

import com.LeoDuarte37.ForgotPassword_Api.dto.RegisterLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.AuthenticateLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.SessionLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.VerifiyOtpDto;
import com.LeoDuarte37.ForgotPassword_Api.model.Login;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * <h1>LoginService</h1>
 * <p>
 *     This is an interface that specifies some methods
 *     and how to implement them to uses operations in
 *     login entity.
 * </p>
 */
public interface LoginService {

    /**
     * Gets login register by username if exists.
     *
     * @param username username associated with user.
     * @return Optional contained Login.
     */
    Optional<Login> getById(String username);

    /**
     * Registers a new login/account.
     *
     * @param registerLoginDto username, password, user and role.
     * @throws ResponseStatusException BAD_REQUEST (400).
     */
    void register(RegisterLoginDto registerLoginDto) throws ResponseStatusException;

    /**
     * Authenticates user credentials.
     *
     * @param authenticateLoginDto username and password.
     * @throws ResponseStatusException FORBIDDEN (403).
     */
    void authenticate(AuthenticateLoginDto authenticateLoginDto) throws ResponseStatusException;

    /**
     * Verify if username and password are valid.
     *
     * @param username username from login.
     * @param password password from login
     * @return Optional contained Login.
     * @throws ResponseStatusException - FORBIDDEN (403).
     */
    Optional<Login> verifyCredentials(String username, String password) throws ResponseStatusException;

    /**
     * Uses OtpService to verify OTP Code exists in cache,
     * and creating a login session if exists.
     *
     * @param verifiyOtpDto username and OTP Code.
     * @return Login session containing username, role and token.
     * @throws ResponseStatusException - FORBIDDEN (403).
     */
    SessionLoginDto verifyCode(VerifiyOtpDto verifiyOtpDto) throws ResponseStatusException;
}
