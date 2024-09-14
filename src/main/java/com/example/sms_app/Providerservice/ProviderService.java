package com.example.sms_app.Providerservice;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProviderService {

    private final RestTemplate restTemplate;

    public ProviderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getProvider1Data() {
        String url = "http://localhost:8081/provider1";
        return restTemplate.getForObject(url, String.class);
    }

    public String postProvider2Data() {
        String url = "http://localhost:8082/provider2";
        return restTemplate.postForObject(url, null, String.class);
    }
}