package com.example.sms_app.service;

import com.example.sms_app.model.Message;
import com.example.sms_app.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsService {

    @Autowired
    private MessageRepository messageRepository;

    public void sendAndSaveSms(String content) {
        sendSms(content);
        saveMessage(content);
    }

    public void sendSms(String content) {
        System.out.println("Sending SMS: " + content);
    }

    public Message saveMessage(String content) {
        Message message = new Message();
        message.setContent(content);
        return messageRepository.save(message);
    }

    private String generateRandomCode() {
        return String.valueOf((int)(Math.random() * 900000) + 100000);
    }

    @Scheduled(fixedRate = 30000)
    public void sendScheduledSms() {
        String randomCode = generateRandomCode();
        String message = "Your current code is " + randomCode;
        sendAndSaveSms(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}

