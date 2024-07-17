package com.LeoDuarte37.ForgotPassword_Api.service;

import com.LeoDuarte37.ForgotPassword_Api.dto.RegisterLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.AuthenticateLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.SessionLoginDto;

public interface LoginService {

    void register(RegisterLoginDto registerLoginDto);
    void authenticate(AuthenticateLoginDto authenticateLoginDto);
}
