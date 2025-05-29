package com.pluralsight.ui;

import com.pluralsight.models.Order;

import java.util.Scanner;

import static com.pluralsight.util.UiHelper.showLoadingSpinner;

public class UserInterface {

    //Lets people type what they want	“Do you want bread?” “White or wheat?” any interaction with user goes here.
//method to display Home scree
    public void homeScreen() {

        boolean exit = false;
        Order myOrder = new Order();

        while (!exit) {
            System.out.println("\n=======================================");
            System.out.println("    Welcome to DELI-cious Sandwich Shop! ");
            System.out.println("=======================================\n");

            // Show loading spinner to simulate processing
            showLoadingSpinner(1500);

            System.out.println("Please select an option:");
            System.out.println("  1) Start a New Order");
            System.out.println("  0) Exit the Shop\n");

            System.out.print(" Your choice: ");

            // Small spinner for better feedback after prompt
            showLoadingSpinner(1000);

            Scanner myScanner = new Scanner(System.in);
            String choice = myScanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("\nGreat! Let’s start your order...\n");
                    showLoadingSpinner(1000);
                    HandleNewOrder newOrder = new HandleNewOrder();
                    newOrder.startOrder();
                    System.out.println("\nThank you for your order! Returning to home screen...\n");
                    showLoadingSpinner(1500);
                    break;

                case "0":
                    System.out.println("\nThanks for visiting DELI-cious! Goodbye! ");
                    exit = true;
                    break;

                default:
                    System.out.println("\nOops! That’s not a valid option. Please try again.\n");
                    // Loop will continue automatically for retry
            }
        }

    }
}
