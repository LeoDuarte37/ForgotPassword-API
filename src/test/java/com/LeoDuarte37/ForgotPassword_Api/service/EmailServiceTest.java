package com.LeoDuarte37.ForgotPassword_Api.service;

import com.LeoDuarte37.ForgotPassword_Api.service.impl.EmailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    private SimpleMailMessage email;

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private EmailServiceImpl emailService;

    @Captor
    private ArgumentCaptor<SimpleMailMessage> captor;

    @BeforeEach
    void setup() {
        email = emailService.createSimpleMailMessage(
                "test@gmail.com",
                "Testing email creation",
                "Hello World!"
        );
    }

    @Test
    void testSendEmail() {
        emailService.sendEmail(email);

        verify(javaMailSender).send(captor.capture());
        SimpleMailMessage emailSent = captor.getValue();

        assertEquals(email.getTo(), emailSent.getTo());
        assertEquals(email.getSubject(), emailSent.getSubject());
        assertEquals(email.getText(), emailSent.getText());
    }

    @Test
    void testCreateSimpleMailMessage() {
        assertNotNull(email.getTo());
        assertEquals("test@gmail.com", email.getTo()[0]);
        assertEquals("Testing email creation", email.getSubject());
        assertEquals("Hello World!", email.getText());
    }
}
