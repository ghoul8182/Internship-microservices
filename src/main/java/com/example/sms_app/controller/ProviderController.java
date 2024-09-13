package com.example.sms_app.controller;

import com.example.sms_app.Providerservice.ProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/api/provider1")
    public String getProvider1Data() {
        return providerService.getProvider1Data();
    }

    @PostMapping("/api/provider2")
    public String postProvider2Data() {
        return providerService.postProvider2Data();
    }
}
