package com.pluralsight.ui;

import com.pluralsight.models.Drink;

import java.util.Scanner;

public class AddDrink {
    public Drink getDrink() {
        // Set up scanner to read user input from the console
        Scanner scanner = new Scanner(System.in);

        // Ask the user if they want a drink
        System.out.print("Would you like a drink? (yes/no): ");
        String answer = scanner.nextLine();

        // If they said "yes", ask for details and create a drink
        if (answer.equalsIgnoreCase("yes")) {
            // Ask for the type of drink (like Coke, Sprite, etc.)
            System.out.print("Enter drink type: ");
            String type = scanner.nextLine();

            // Ask for the drink size (Small/Medium/Large)
            System.out.print("Enter size (Small/Medium/Large): ");
            String size = scanner.nextLine();


            // Return a new Drink object with the type and size the user gave
            Drink myDrink = new Drink(size, type);

            return myDrink;
        }

        // If they said "no", return nothing (null) — meaning no drink was selected
        return null;
    }
}
