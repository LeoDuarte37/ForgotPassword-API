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

@RestController
@RequestMapping("/api/v1/auth")
public class LoginResource {

    @Autowired
    private LoginService loginService;

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

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void authenticate(@RequestBody @Valid AuthenticateLoginDto authenticateLoginDto) {
        loginService.authenticate(authenticateLoginDto);
    }

    @PostMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public SessionLoginDto verifyCode(@RequestBody @Valid VerifiyOtpDto verifiyOtpDto) {
        return loginService.verifyCode(verifiyOtpDto);
    }
}
