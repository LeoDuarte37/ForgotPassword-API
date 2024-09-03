package com.LeoDuarte37.ForgotPassword_Api.service.impl;

import com.LeoDuarte37.ForgotPassword_Api.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * <h1>EmailServiceImpl</h1>
 * <p>
 *     This class is responsible for implementing methods
 *     specified in the EmailService.
 * </p>
 *
 * @author Leonardo
 * @version 1.0
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(SimpleMailMessage mailMessage) {
        try {
            javaMailSender.send(mailMessage);
        } catch(MailException e) {
            System.out.println("Error sending email! " + e.getMessage());
        }
    }

    public SimpleMailMessage createSimpleMailMessage(String to, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        return mailMessage;
    }
}
