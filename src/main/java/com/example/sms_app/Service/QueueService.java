package com.example.sms_app.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE = "sms_exchange";

    public void sendToQueue1(String message) {
        String routingKeyQueue1 = "queue1";
        try {
            rabbitTemplate.convertAndSend(EXCHANGE, routingKeyQueue1, message);
            System.out.println("Message sent to Queue 1: " + message);
        } catch (Exception e) {
            System.err.println("Error sending message to Queue 1: " + e.getMessage());
        }
    }

    public void sendToQueue2(String message) {
        String routingKeyQueue2 = "queue2";
        try {
            rabbitTemplate.convertAndSend(EXCHANGE, routingKeyQueue2, message);
            System.out.println("Message sent to Queue 2: " + message);
        } catch (Exception e) {
            System.err.println("Error sending message to Queue 2: " + e.getMessage());
        }
    }
}

