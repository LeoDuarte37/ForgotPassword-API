package com.LeoDuarte37.ForgotPassword_Api.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtServiceImpl {

    @Value("${auth.jwt.token.secret}")
    private final String SECRET_KEY;

    @Value("${auth.jwt.token.expiration}")
    private final Integer EXPIRATION;

    public JwtServiceImpl(String secretKey, Integer expiration) {
        SECRET_KEY = secretKey;
        EXPIRATION = expiration;
    }

    public String generateToken(String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

            return JWT.create()
                    .withIssuer("ForgotPassword-Api")
                    .withSubject(username)
                    .withExpiresAt(generateDateExpiration())
                    .sign(algorithm);

        } catch (JWTCreationException e) {
            throw new JWTCreationException("Error generating token! - " + e.getMessage(), e);
        }
    }

    public String verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

            return JWT.require(algorithm)
                    .withIssuer("ForgotPassword-Api")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException e) {
            throw new JWTVerificationException("Invalid token! - " + e.getMessage());
        }
    }

    private Instant generateDateExpiration() {
        return LocalDateTime.now().plusHours(EXPIRATION).toInstant(ZoneOffset.of("-03:00"));
    }
}
