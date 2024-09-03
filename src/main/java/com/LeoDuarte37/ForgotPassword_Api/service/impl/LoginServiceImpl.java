package com.LeoDuarte37.ForgotPassword_Api.service.impl;

import com.LeoDuarte37.ForgotPassword_Api.dto.AuthenticateLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.RegisterLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.SessionLoginDto;
import com.LeoDuarte37.ForgotPassword_Api.dto.VerifiyOtpDto;
import com.LeoDuarte37.ForgotPassword_Api.mapper.LoginMapper;
import com.LeoDuarte37.ForgotPassword_Api.model.Login;
import com.LeoDuarte37.ForgotPassword_Api.repository.LoginRepository;
import com.LeoDuarte37.ForgotPassword_Api.service.EmailService;
import com.LeoDuarte37.ForgotPassword_Api.service.JwtService;
import com.LeoDuarte37.ForgotPassword_Api.service.LoginService;
import com.LeoDuarte37.ForgotPassword_Api.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * <h1>LoginServiceImpl</h1>
 * <p>
 *     This class is responsible for implementing methods
 *     specified in the LoginService.
 * </p>
 *
 * @author Leonardo
 * @version 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private OtpService otpService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Optional<Login> getById(String username) {
        return loginRepository.findById(username);
    }

    @Override
    public void register(RegisterLoginDto registerLoginDto) throws ResponseStatusException {
        if (loginRepository.existsById(registerLoginDto.username())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username unavailable!");
        }

        loginRepository.save(loginMapper.toEntity(registerLoginDto));
    }

    @Override
    public void authenticate(AuthenticateLoginDto authenticateLoginDto) throws ResponseStatusException {
        try {
            Optional<Login> login = verifyCredentials(
                    authenticateLoginDto.username(),
                    authenticateLoginDto.password()
            );

            if(login.isPresent()) {
                Integer otp = otpService.generateOtp(login.get().getUsername());

                SimpleMailMessage mailMessage = emailService.createSimpleMailMessage(
                        login.get().getUser().getEmail(),
                        "Two Factor Authentication",
                        "Your verification code: " + otp
                );

                emailService.sendEmail(mailMessage);
            }
        } catch (ResponseStatusException e) {
            throw e;
        }
    }

    @Override
    public Optional<Login> verifyCredentials(String username, String password) throws ResponseStatusException {
        var credentials = new UsernamePasswordAuthenticationToken(username, password);

        Authentication authentication = authenticationManager.authenticate(credentials);

        if (authentication.isAuthenticated()) {
            return getById(username);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid credentials!");
        }
    }

    @Override
    public SessionLoginDto verifyCode(VerifiyOtpDto verifiyOtpDto) throws ResponseStatusException {
        boolean validOtp = otpService.validateOtp(verifiyOtpDto.username(), verifiyOtpDto.otp());

        if (!validOtp) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid OTP");
        }

        return getById(verifiyOtpDto.username())
                .map(entity -> {
                    String token = jwtService.generateToken(entity.getUsername());
                    return loginMapper.toSession(entity, token);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));
    }
}
