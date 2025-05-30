package com.pluralsight.ui;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;
import com.pluralsight.util.*;

import java.util.Scanner;

public class CheckOutAndPrint {
    Scanner myScanner = new Scanner(System.in);

    public void printReceipt(Order order) {

        // Start with the base price of the sandwich
        double total = 0;

        // Use StringBuilder to create the receipt text
        StringBuilder receipt = new StringBuilder();

        // Add sandwich details to the receipt if not null
        for (Sandwich sandwich : order.getSandwiches()) {
            receipt.append(sandwich.getSummary()).append("\n");
            total += sandwich.getPrice();
        }

        // If the customer ordered a drink, add it to the receipt and update total
        for (Drink drink : order.getDrinks()) {
            receipt.append("Drink: ").append(drink.getType()).append(" (" + drink.getSize() + ")\n");
            total += drink.getPrice();
        }

        // If the customer ordered chips, add to the receipt and update total
        for (Chips chips : order.getChips()) {
            receipt.append("Chips: ").append(chips.getFlavor()).append("\n");
            total += chips.getPrice();
        }

        // Add the total price of the entire order to the receipt
        receipt.append("Total Order Price: $").append(String.format("%.2f", total));

        // Print the receipt to the console
        System.out.println(receipt);
        System.out.println("Is this order correct? : Y");
        String userChoice = myScanner.nextLine();
        if (userChoice.equalsIgnoreCase("y")) {
            // Save using the new ReceiptWriter utility class
            ReceiptWriter.saveReceiptToFile(receipt.toString());
        } else {
            System.out.println(" Order Canceled");
        }

    }


}



