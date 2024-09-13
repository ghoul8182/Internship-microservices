package com.example.sms_app.Providerservice;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UserInputService {

    private final ProviderService providerService;

    public UserInputService(ProviderService providerService) {
        this.providerService = providerService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = getUserChoice(scanner);

            if (choice == 1) {
                handleProvider1();
            } else if (choice == 2) {
                handleProvider2();
            } else if (choice == 0) {
                System.out.println("Exiting...");
                break;
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
        String response = providerService.getProvider1Data();
        System.out.println("Response from Provider 1: " + response);
    }

    private void handleProvider2() {
        String response = providerService.postProvider2Data();
        System.out.println("Response from Provider 2: " + response);
    }
}
