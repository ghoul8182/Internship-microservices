package com.example.sms_app.controller;

import com.example.sms_app.Service.RandomActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/random")
public class RandomActionController {

    @Autowired
    private RandomActionService randomActionService;

    @PostMapping
    public String performRandomAction(@RequestBody String message) {
        return randomActionService.performRandomAction(message);
    }
}

