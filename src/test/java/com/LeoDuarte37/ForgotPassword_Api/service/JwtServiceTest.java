package com.LeoDuarte37.ForgotPassword_Api.service;

import com.LeoDuarte37.ForgotPassword_Api.service.impl.JwtServiceImpl;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JwtServiceTest {

    private static String username;

    private static JwtServiceImpl jwtService;

    @BeforeAll
    static void setup() {
        username = "Leonardo";
        jwtService = new JwtServiceImpl("0eacaf64406708f5fb197b90fe800a2d", 1);
    }

    @Test
    void testGenerateToken() {
        String token = jwtService.generateToken(username);
        String verifiedUsername  = jwtService.verifyToken(token);

        Assertions.assertEquals(username, verifiedUsername);
    }

    @Test
    void testVerifyToken() {
        Assertions.assertThrows(JWTVerificationException.class, () -> jwtService.verifyToken("InvalidToken!"));
    }

    @Test
    void testTokenExpiration() {
        String token = jwtService.generateToken(username);

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Assertions.assertThrows(JWTVerificationException.class, () -> jwtService.verifyToken(token));
    }
}
