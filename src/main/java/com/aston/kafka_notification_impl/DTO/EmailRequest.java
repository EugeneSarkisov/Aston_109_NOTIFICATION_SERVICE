package com.aston.kafka_notification_impl.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailRequest {
    private String emailTo;
    private String emailUsername;
    private String emailBody;

}
