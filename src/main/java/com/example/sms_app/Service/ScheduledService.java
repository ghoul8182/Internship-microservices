package com.example.sms_app.Service;

import com.example.sms_app.Util.CodeGenerator;
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
        String randomCode = CodeGenerator.generateRandomCode();
        String message = "Your current code is " + randomCode;
        smsService.sendAndSaveSms(message);
    }
    @Scheduled(fixedRate = 10000) // 10 seconds
    public void consumeQueue2() {
        String message = (String) rabbitTemplate.receiveAndConvert("queue2");
        if (message != null) {
            System.out.println("Consumed from Queue 2: " + message);
        }
    }
}
