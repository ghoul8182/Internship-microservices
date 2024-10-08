package com.example.provider.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Provider1 {
    @GetMapping("/provider1")
    public String getProvider1Info() {
        return "Hello from provider 1";
    }
    @PostMapping("/provider1")
    public String postProvider1Info(@RequestBody String message) {
        System.out.println("Received message from provider 1 Controller: " + message);
        return "Received message: " + message;
    }

}


