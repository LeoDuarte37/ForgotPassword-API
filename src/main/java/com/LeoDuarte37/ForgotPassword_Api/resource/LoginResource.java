package com.LeoDuarte37.ForgotPassword_Api.resource;

import com.LeoDuarte37.ForgotPassword_Api.dto.AuthenticateLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.RegisterLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.SessionLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.VerifiyCodeDto;
import com.LeoDuarte37.ForgotPassword_Api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginResource {

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    @Transactional
    public void register(RegisterLoginDto registerLoginDto) {
        loginService.register(registerLoginDto);
    }

    @PostMapping
    @Transactional
    public void authenticate(AuthenticateLoginDto authenticateLoginDto) {
        loginService.authenticate(authenticateLoginDto);
    }

    @PostMapping("/verify")
    @Transactional
    public SessionLoginDto verifyCode(VerifiyCodeDto verifiyCodeDto) {
        return loginService.verifyCode(verifiyCodeDto);
    }
}
