package com.LeoDuarte37.ForgotPassword_Api.service;

import com.LeoDuarte37.ForgotPassword_Api.dto.RegisterLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.AuthenticateLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.SessionLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.VerifiyOtpDto;
import org.springframework.web.server.ResponseStatusException;

public interface LoginService {

    void register(RegisterLoginDto registerLoginDto) throws ResponseStatusException;

    void authenticate(AuthenticateLoginDto authenticateLoginDto) throws ResponseStatusException;

    SessionLoginDto verifyCode(VerifiyOtpDto verifiyOtpDto) throws ResponseStatusException;
}
