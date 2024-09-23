package com.example.sms_app.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rabbitmq")
public class QueueController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE = "sms_exchange";
    private static final String ROUTING_KEY_QUEUE1 = "queue1";
    private static final String ROUTING_KEY_QUEUE2 = "queue2";

    // Push message to Queue 1
    @PostMapping("/queue1")
    public String pushToQueue1(@RequestBody String message) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_QUEUE1, message);
        return "Message pushed to Queue 1!";
    }

    // Push message to Queue 2
    @PostMapping("/queue2")
    public String pushToQueue2(@RequestBody String message) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_QUEUE2, message);
        return "Message pushed to Queue 2!";
    }
}
