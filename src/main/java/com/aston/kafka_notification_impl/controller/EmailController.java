package com.aston.kafka_notification_impl.controller;

import com.aston.kafka_notification_impl.DTO.EmailRequest;
import com.aston.kafka_notification_impl.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/email")
public class EmailController {
    private final NotificationService service;

    @PostMapping("/send_email")
    public boolean sendEmail(@RequestBody EmailRequest request){
        service.send(request.getEmailTo(), request.getEmailUsername(), request.getEmailBody());
        return true;
    }

}
