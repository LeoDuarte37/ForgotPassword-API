package com.LeoDuarte37.ForgotPassword_Api.service;

import com.LeoDuarte37.ForgotPassword_Api.dto.AddLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.LoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.SessionLoginDto;

public interface LoginService {

    void register(AddLoginDto addLoginDto);
    SessionLoginDto authenticate(LoginDto loginDto);
    void verifyCode();
}
