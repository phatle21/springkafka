package com.example.test.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "quickstart-events", groupId = "default-group")
    public void receive(String message) {
        messagingTemplate.convertAndSend("/topic/notification", message);
    }
}

