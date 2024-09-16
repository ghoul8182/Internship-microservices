package com.example.sms_app.controller;

import com.example.sms_app.Service.Provider1Service;
import com.example.sms_app.Service.Provider2Service;
import com.example.sms_app.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/random")
public class RandomActionController {

    @Autowired
    private Provider1Service provider1Service;

    @Autowired
    private Provider2Service provider2Service;

    private static final Random RANDOM = new Random();

    @PostMapping
    public String performRandomAction(@RequestBody String message) {
        int action = RANDOM.nextInt(3); // Randomly choose 0, 1, or 2
        switch (action) {
            case 0:
                provider1Service.sendSMS(message);
                return "Message sent via Provider 1";
            case 1:
                provider2Service.sendSMS(message);
                return "Message sent via Provider 2";
            case 2:
                throw new CustomException("Randomly thrown custom exception");
            default:
                throw new CustomException("Unexpected error");
        }
    }
}
