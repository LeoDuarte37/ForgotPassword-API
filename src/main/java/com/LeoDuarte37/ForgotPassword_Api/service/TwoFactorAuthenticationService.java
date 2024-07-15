package com.LeoDuarte37.ForgotPassword_Api.service;

public interface TwoFactorAuthenticationService {

    String generateNewSecret();

    String generateQrCodeImageUri(String secret);

    boolean isOtpValid(String secret, String code);
}
