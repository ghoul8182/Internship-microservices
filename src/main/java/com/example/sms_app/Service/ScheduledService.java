package com.example.sms_app.Service;

import com.example.sms_app.Util.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    @Autowired
    private SmsService smsService;

    @Scheduled(fixedRate = 30000)
    public void sendScheduledSms() {
        String randomCode = CodeGenerator.generateRandomCode();
        String message = "Your current code is " + randomCode;
        smsService.sendAndSaveSms(message);
    }
}
