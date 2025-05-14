package com.aston.kafka_notification_impl.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccountDeletedEvent {
    private String username;
    private String notification;
    private String email;

}
