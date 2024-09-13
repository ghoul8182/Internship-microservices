package com.example.sms_app.ServiceSec;

import com.example.sms_app.service_sms.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Autowired
    private SmsService smsService;

    @Scheduled(fixedRate = 30000) // Every 30 seconds
    public void sendScheduledSms() {
        String randomCode = CodeGenerator.generateRandomCode();
        String message = "Your current code is " + randomCode;
        smsService.sendAndSaveSms(message);
    }
}
