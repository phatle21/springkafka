package com.example.test.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class KafkaController {
    @MessageMapping("/hello") // Client send to server /app/hello
    @SendTo("/topic/notification") // Server send to client /topic/notification
    public String send(String id_schedule) {
        System.out.println(id_schedule);
        return id_schedule;
    }
}
