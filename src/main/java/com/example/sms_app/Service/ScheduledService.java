package com.example.sms_app.Service;

import com.example.sms_app.Util.CodeGenerator;
import com.example.sms_app.exception.CustomException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Autowired
    private SmsService smsService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedRate = 3600000) // 1 hour
    public void sendScheduledSms() {
        try {
            String randomCode = CodeGenerator.generateRandomCode();
            String message = "Your current code is " + randomCode;
            smsService.sendAndSaveSms(message);
        } catch (Exception ex) {
            throw new CustomException("Error occurred while sending scheduled SMS: " + ex.getMessage());
        }
    }

    @Scheduled(fixedRate = 10000) // 10 seconds
    public void consumeQueue2() {
        try {
            String message = (String) rabbitTemplate.receiveAndConvert("queue2");
            if (message != null) {
                System.out.println("Consumed from Queue 2: " + message);
                smsService.sendAndSaveSms(message);
            }
        } catch (Exception ex) {
            throw new CustomException("Error occurred while consuming from Queue 2: " + ex.getMessage());
        }
    }
}

