package com.aston.kafka_notification_impl.util;

import com.aston.kafka_notification_impl.event.UserAccountCreatedEvent;
import com.aston.kafka_notification_impl.event.UserAccountDeletedEvent;
import com.aston.kafka_notification_impl.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = {"crud-api-events-topic" , "crud-api-error-events-topic"})
@RequiredArgsConstructor
public class KafkaConsumer {

    private final NotificationService service;

    @KafkaHandler
    public void createListener(UserAccountCreatedEvent event){
        service.send(event.getEmail(), event.getUsername(), event.getNotification());
        System.out.println(event.getNotification());
    }

    @KafkaHandler
    public void deleteListener(UserAccountDeletedEvent event){
        service.send(event.getEmail(), event.getUsername(), event.getNotification());
        System.out.println(event.getNotification());
    }

}
