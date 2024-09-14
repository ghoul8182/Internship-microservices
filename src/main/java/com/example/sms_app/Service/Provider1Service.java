package com.example.sms_app.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Provider1Service implements ISMSProvider {

    private final RestTemplate restTemplate;

    public Provider1Service(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void sendSMS(String message) {
        String url = "http://localhost:8081/provider1";
        restTemplate.getForObject(url, String.class);
        System.out.println("Sent SMS via Provider1 with GET request: " + message);
    }
    public String getProvider1Data() {
        String url = "http://localhost:8081/provider1";
        return restTemplate.getForObject(url, String.class);
    }
}