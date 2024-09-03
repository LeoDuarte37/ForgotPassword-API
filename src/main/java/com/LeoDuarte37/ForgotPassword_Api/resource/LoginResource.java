package com.LeoDuarte37.ForgotPassword_Api.resource;

import com.LeoDuarte37.ForgotPassword_Api.dto.AuthenticateLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.RegisterLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.SessionLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.VerifiyOtpDto;
import com.LeoDuarte37.ForgotPassword_Api.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * <h1>LoginResource</h1>
 * <p>
 *     This class is responsible for grouping endpoints,
 *     for operations on the Login entity.
 * </p>
 *
 * @author Leonardo
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1/auth")
public class LoginResource {

    @Autowired
    private LoginService loginService;

    /**
     * <p>
     *     POST type HTTP Method that registers
     *     a new login/account.
     * </p>
     * <h4>
     *     Endpoint: api/v1/auth/register
     * </h4>
     *
     * @param registerLoginDto username, password, user and role.
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void register(@RequestBody @Valid RegisterLoginDto registerLoginDto) {
        try {
            loginService.register(registerLoginDto);
        } catch (ResponseStatusException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * <p>
     *     POST type HTTP Method that authenticates
     *     a login/account.
     * </p>
     * <h4>
     *     Endpoint: api/v1/auth
     * </h4>
     *
     * @param authenticateLoginDto username and password.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void authenticate(@RequestBody @Valid AuthenticateLoginDto authenticateLoginDto) {
        loginService.authenticate(authenticateLoginDto);
    }

    /**
     * <p>
     *     POST type HTTP Method that verifies
     *     OTP Code sent by email.
     * </p>
     * <h4>
     *     Endpoint: api/v1/auth/verify
     * </h4>
     *
     * @param verifiyOtpDto username and otp code.
     * @return A login session containing username, role and token.
     */
    @PostMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public SessionLoginDto verifyCode(@RequestBody @Valid VerifiyOtpDto verifiyOtpDto) {
        return loginService.verifyCode(verifiyOtpDto);
    }
}
