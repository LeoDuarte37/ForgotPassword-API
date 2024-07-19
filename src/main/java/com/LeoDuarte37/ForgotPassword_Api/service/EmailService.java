package com.LeoDuarte37.ForgotPassword_Api.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendEmail(String to, String subject, String message);

    SimpleMailMessage generateSimpleMailMessage(String to, String subject, String message);
}
