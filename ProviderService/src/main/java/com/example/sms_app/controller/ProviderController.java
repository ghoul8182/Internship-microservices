package com.example.sms_app.controller;

import com.example.sms_app.Service.Provider1Service;
import com.example.sms_app.Service.Provider2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/send")
public class ProviderController {

    @Autowired
    private Provider1Service provider1Service;

    @Autowired
    private Provider2Service provider2Service;

    @PostMapping("/provider1")
    public String sendViaProvider1(@RequestBody String message) {
        provider1Service.sendSMS(message);
        return "Sent via Provider1!";
    }

    @PostMapping("/provider2")
    public String sendViaProvider2(@RequestBody String message) {
        provider2Service.sendSMS(message);
        return "Sent via Provider2!";
    }

    @GetMapping("/provider1")
    public String getProvider1Data() {
        return provider1Service.getProvider1Data();
    }

    @GetMapping("/provider2")
    public String getProvider2Data() {
        return provider2Service.getProvider2Data();
    }
}

