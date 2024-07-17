package com.LeoDuarte37.ForgotPassword_Api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = generateSimpleMailMessage(to, subject, message);

        try {
            javaMailSender.send(simpleMailMessage);
        } catch(MailException e) {
            System.out.println("Error sending email! " + e.getMessage());
        }
    }

    public SimpleMailMessage generateSimpleMailMessage(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText("Your verification code: " + message);

        return simpleMailMessage;
    }
}
