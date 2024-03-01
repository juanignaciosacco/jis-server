package com.jisdevelopment.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String email;

    public void sendListEmail(String asunto, String mensaje, String userMail) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(email);
            helper.setTo("hi@jisdevelopment.com");
            helper.setReplyTo(userMail);
            helper.setSubject(asunto);
            helper.setText(mensaje, true);
            javaMailSender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
