package com.aston.kafka_notification_impl.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class EmailControllerTest {

    private MockMvc mockMvc;

    @Test
    void testGetUserInfo_ShouldGetOkStatusCode(){
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/email/send_email")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content("{\"emailTo\": \"111@mail.test\", \"emailUsername\": \"Rut\", \"emailBody\": \"SampleText\"}"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(content().string("true"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}