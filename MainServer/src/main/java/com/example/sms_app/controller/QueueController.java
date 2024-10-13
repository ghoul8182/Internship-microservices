package com.example.sms_app.controller;

import com.example.sms_app.Service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rabbitmq")
public class QueueController {

    @Autowired
    private QueueService queueService;

    @PostMapping("/queue1")
    public String pushToQueue1(@RequestBody String message) {
        System.out.println(" hit for Queue 1");
        queueService.sendToQueue1(message);
        return "Message pushed to Queue 1!";
    }

    @PostMapping("/queue2")
    public String pushToQueue2(@RequestBody String message) {
        System.out.println(" hit for Queue 2");
        queueService.sendToQueue2(message);
        return "Message pushed to Queue 2!";
    }
}


