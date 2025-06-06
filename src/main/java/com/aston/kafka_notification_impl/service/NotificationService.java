package com.aston.kafka_notification_impl.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;
    @CircuitBreaker(name = "circuitBreaker", fallbackMethod = "userEventFallback")
    public void send(String to, String subject, String body){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        mailMessage.setFrom(from);
        javaMailSender.send(mailMessage);
    }
    public void userEventFallback() {
        System.out.println("Unavailable to send notification.");
    }
}
