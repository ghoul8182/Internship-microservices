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
        try {
            restTemplate.postForObject(url, message, String.class);
            System.out.println("Sent SMS via Provider1: " + message);
        } catch (Exception ex) {
            System.err.println("Error when sending SMS via Provider1: " + ex.getMessage());
            throw new RuntimeException("Unexpected error occurred when sending SMS via Provider1", ex);
        }
    }

    public String getProvider1Data() {
        String url = "http://localhost:8081/provider1";
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception ex) {
            System.err.println("Error when fetching data from Provider1: " + ex.getMessage());
            throw new RuntimeException("Unexpected error occurred when fetching data from Provider1", ex);
        }
    }
}


