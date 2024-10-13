package com.example.sms_app.listener;

import com.example.sms_app.exception.CustomException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SmsListener {

    @RabbitListener(queues = "queue1")
    public void consumeQueue1(String message) {
        try {
            System.out.println("Consumed from Queue 1: " + message);
        } catch (Exception ex) {
            throw new CustomException("Error consuming message from Queue 1: " + ex.getMessage());
        }
    }

    @RabbitListener(queues = "queue2")
    public void consumeQueue2(String message) {
        try {
            System.out.println("Consumed from Queue 2: " + message);
        } catch (Exception ex) {
            throw new CustomException("Error consuming message from Queue 2: " + ex.getMessage());
        }
    }
}
