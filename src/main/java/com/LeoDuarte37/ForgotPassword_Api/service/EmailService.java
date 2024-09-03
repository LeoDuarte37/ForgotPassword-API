package com.LeoDuarte37.ForgotPassword_Api.service;

import org.springframework.mail.SimpleMailMessage;

/**
 * <h1>EmailService</h1>
 * <p>
 *     This is an interface that specifies some
 *     methods and how to implement them to
 *     send simple messages via email.
 * </p>
 */
public interface EmailService {

    /**
     * Send a simple email message.
     * @param mailMessage SimpleMailMessage.
     */
    void sendEmail(SimpleMailMessage mailMessage);

    /**
     * Create a SimpleMailMessage.
     *
     * @param to recipient.
     * @param subject subject.
     * @param message text message.
     * @return SimpleMailMessage.
     */
    SimpleMailMessage createSimpleMailMessage(String to, String subject, String message);
}
