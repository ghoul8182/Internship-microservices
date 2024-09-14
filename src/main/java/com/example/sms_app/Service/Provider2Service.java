package com.example.sms_app.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Provider2Service implements ISMSProvider {

    private final RestTemplate restTemplate;

    public Provider2Service(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void sendSMS(String message) {
        String url = "http://localhost:8081/provider2";
        restTemplate.postForObject(url, message, String.class);
        System.out.println("Sent SMS via Provider2 with POST request: " + message);
    }
    public String postProvider2Data() {
        String url = "http://localhost:8081/provider2";
        return restTemplate.postForObject(url, null, String.class);
    }
}