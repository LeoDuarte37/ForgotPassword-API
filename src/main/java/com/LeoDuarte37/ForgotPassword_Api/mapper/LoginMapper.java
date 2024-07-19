package com.LeoDuarte37.ForgotPassword_Api.mapper;

import com.LeoDuarte37.ForgotPassword_Api.dto.RegisterLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.SessionLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.enumeration.Role;
import com.LeoDuarte37.ForgotPassword_Api.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Login toEntity(RegisterLoginDto registerLoginDto) {
        return new Login(
                registerLoginDto.username(),
                passwordEncoder.encode(registerLoginDto.password()),
                registerLoginDto.user(),
                Role.getRoleByKey(registerLoginDto.role())
        );
    }

    public SessionLoginDto toSession(Login login, String token) {
        return new SessionLoginDto(
                login.getUsername(),
                login.getRole().toString(),
                token
        );
    }
}
