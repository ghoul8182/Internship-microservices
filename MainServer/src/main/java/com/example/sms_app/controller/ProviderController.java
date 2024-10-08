package com.example.sms_app.controller;

import com.example.sms_app.Service.ISMSProvider;
import com.example.sms_app.Service.Provider1Service;
import com.example.sms_app.Service.Provider2Service;
import com.example.sms_app.Service.SMSProviderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/send")
public class ProviderController {

    private final SMSProviderFactory providerFactory;

    @Autowired
    public ProviderController(SMSProviderFactory providerFactory) {
        this.providerFactory = providerFactory;
    }

    @PostMapping
    public String sendSms(@RequestParam int providerType, @RequestBody String message) {
        ISMSProvider provider = providerFactory.getProvider(providerType);
        provider.sendSMS(message);
        return "Sent via Provider " + providerType + "!";
    }

    @GetMapping("/provider1")
    public String getProvider1Data() {
        return ((Provider1Service) providerFactory.getProvider(1)).getProvider1Data();
    }

    @GetMapping("/provider2")
    public String getProvider2Data() {
        return ((Provider2Service) providerFactory.getProvider(2)).getProvider2Data();
    }
}

