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
        try {
            restTemplate.postForObject(url, message, String.class);
            System.out.println("Sent SMS via Provider2: " + message);
        } catch (Exception ex) {
            System.err.println("Error when sending SMS via Provider2: " + ex.getMessage());
            throw new RuntimeException("Unexpected error occurred when sending SMS via Provider2", ex);
        }
    }

    public String getProvider2Data() {
        String url = "http://localhost:8081/provider2";
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception ex) {
            System.err.println("Error when fetching data from Provider2: " + ex.getMessage());
            throw new RuntimeException("Unexpected error occurred when fetching data from Provider2", ex);
        }
    }
}



