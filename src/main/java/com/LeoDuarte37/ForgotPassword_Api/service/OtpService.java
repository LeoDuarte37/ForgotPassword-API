package com.LeoDuarte37.ForgotPassword_Api.service;

public interface OtpService {

    Integer generateOtp(String key);

    Integer getOtpByKey(String key);

    void clearOtpFromCache(String key);

    boolean validateOtp(String key, Integer otp);
}
