package com.Dhiraj.Service;

import org.springframework.mail.MailSendException;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendVerificationOtpEmail(String userEmail, String otp) throws MessagingException, MailSendException;
}
