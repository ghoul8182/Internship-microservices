package com.example.sms_app.Service;

import com.example.sms_app.Service.Provider1Service;
import com.example.sms_app.Service.Provider2Service;
import com.example.sms_app.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomActionService {

    @Autowired
    private Provider1Service provider1Service;

    @Autowired
    private Provider2Service provider2Service;

    private static final Random RANDOM = new Random();

    public String performRandomAction(String message) {
        int action = RANDOM.nextInt(3);
        switch (action) {
            case 0:
                provider1Service.sendSMS(message);
                return "Message sent via Provider 1";
            case 1:
                provider2Service.sendSMS(message);
                return "Message sent via Provider 2";
            case 2:
                throw new CustomException(" Thrown custom exception");
            default:
                throw new CustomException("Unexpected error");
        }
    }
}
