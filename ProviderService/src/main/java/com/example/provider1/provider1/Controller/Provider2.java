package com.example.provider1.provider1.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Provider2 {

    @PostMapping("/provider2")
    public String postProvider2Info(@RequestBody String message) {
        System.out.println("Received message from Provider 2 Controller : " + message);
        return "Received message: " + message;
    }
    @GetMapping("/provider2")
    public String getProvider2Info() {
        return "Hello from provider 2";
    }
}


