package com.example.sms_app.Providerservice;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@Service
public class ProviderService {

    private final RestTemplate restTemplate;

    public ProviderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getUserChoice(scanner);

            if (choice == 1) {
                handleProvider1();
            } else if (choice == 2) {
                handleProvider2();
            } else if (choice == 0) {
                System.out.println("Exiting...");
                running = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private void printMenu() {
        System.out.println("Choose Provider:");
        System.out.println("1: Provider 1 (GET)");
        System.out.println("2: Provider 2 (POST)");
        System.out.println("0: Exit");
    }

    private int getUserChoice(Scanner scanner) {
        System.out.print("Enter choice: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); 
        }
        return scanner.nextInt();
    }
    private void handleProvider1() {
        String url = "http://localhost:8080/provider1";
        String response = restTemplate.getForObject(url, String.class);
        System.out.println("Response from Provider 1: " + response);
    }

    private void handleProvider2() {
        String url = "http://localhost:8082/provider2";
        String response = restTemplate.postForObject(url, null, String.class);
        System.out.println("Response from Provider 2: " + response);
    }
}
