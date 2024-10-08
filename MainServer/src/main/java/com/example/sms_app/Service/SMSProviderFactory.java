package com.example.sms_app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SMSProviderFactory {

    private final Provider1Service provider1Service;
    private final Provider2Service provider2Service;

    @Autowired
    public SMSProviderFactory(Provider1Service provider1Service, Provider2Service provider2Service) {
        this.provider1Service = provider1Service;
        this.provider2Service = provider2Service;
    }

    public ISMSProvider getProvider(int providerType) {
        switch (providerType) {
            case 1:
                return provider1Service;
            case 2:
                return provider2Service;
            default:
                throw new IllegalArgumentException("Unknown provider type: " + providerType);
        }
    }
}
