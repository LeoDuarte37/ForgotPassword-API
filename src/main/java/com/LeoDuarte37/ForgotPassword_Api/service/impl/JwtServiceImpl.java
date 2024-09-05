package com.LeoDuarte37.ForgotPassword_Api.service.impl;

import com.LeoDuarte37.ForgotPassword_Api.service.JwtService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * <h1>JwtServiceImpl</h1>
 * <p>
 *     This class is responsible for implementing methods
 *     specified in the JwtService.
 * </p>
 *
 * @author Leonardo
 * @version 1.0
 */
@Service
public class JwtServiceImpl implements JwtService {

    @Value("${auth.jwt.token.secret}")
    private String secret;

    @Value("${auth.jwt.token.expiration}")
    private Integer expiration;

    public JwtServiceImpl(String secret, Integer expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    public String generateToken(String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

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
            Algorithm algorithm = Algorithm.HMAC256(secret);

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
        // return LocalDateTime.now().plusHours(expiration).toInstant(ZoneOffset.of("-03:00"));
        return LocalDateTime.now().plusMinutes(expiration).toInstant(ZoneOffset.of("-03:00"));
    }
}
