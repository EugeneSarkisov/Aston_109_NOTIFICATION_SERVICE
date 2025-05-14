package com.aston.kafka_notification_impl.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccountCreatedEvent {
    private String username;
    private String email;
    private String notification;

}
