package com.example.sms_app.Service;

import com.example.sms_app.exception.CustomException;
import com.example.sms_app.model.Message;
import com.example.sms_app.repository.MessageRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(Long id) {
        Optional<Message> message = messageRepository.findById(id);
        return message.orElse(null);
    }

    public void deleteMessageById(Long id) {
        messageRepository.deleteById(id);
    }

    public Message updateMessage(Long id, String newContent) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            message.setContent(newContent);
            return messageRepository.save(message);
        }
        return null;
    }


}

