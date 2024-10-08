package com.example.sms_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsAppApplication.class, args);
	}

}
