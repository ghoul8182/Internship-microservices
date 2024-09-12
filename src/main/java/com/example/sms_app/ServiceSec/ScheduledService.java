package com.example.sms_app.ServiceSec;

import com.example.sms_app.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Autowired
    private SmsService smsService;

    private String generateRandomCode() {
        return String.valueOf((int)(Math.random() * 900000) + 100000);
    }

    @Scheduled(fixedRate = 30000) // Every 30 seconds
    public void sendScheduledSms() {
        String randomCode = generateRandomCode();
        String message = "Your current code is " + randomCode;
        smsService.sendAndSaveSms(message);
    }
}
