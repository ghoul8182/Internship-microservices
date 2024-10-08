package com.example.sms_app.controller;

import com.example.sms_app.Service.SmsService;
import com.example.sms_app.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/send")
    public ResponseEntity<String> sendSms(@RequestBody String messageContent) {
        smsService.sendAndSaveSms(messageContent);
        return ResponseEntity.ok("SMS sent!");
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = smsService.getAllMessages();
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        Message message = smsService.getMessageById(id);
        if (message == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Void> deleteMessageById(@PathVariable Long id) {
        smsService.deleteMessageById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessageById(@PathVariable Long id, @RequestBody String newContent) {
        Message updatedMessage = smsService.updateMessage(id, newContent);
        if (updatedMessage == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMessage);
    }
}
