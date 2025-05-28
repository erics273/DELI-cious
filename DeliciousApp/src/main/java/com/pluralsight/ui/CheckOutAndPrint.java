package com.pluralsight.ui;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Sandwich;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckOutAndPrint {

        public void printReceipt(Sandwich sandwich, Drink drink, Chips chips) {

            // Start with the base price of the sandwich
            double total = sandwich.getPrice();

            // Use StringBuilder to create the receipt text
            StringBuilder receipt = new StringBuilder();

            // Add sandwich details to the receipt
            receipt.append(sandwich.getSummary()).append("\n");

            // If the customer ordered a drink, add it to the receipt and update total
            if (drink != null) {
                receipt.append("Drink: ").append(drink.getType()).append(" (" + drink.getSize() + ")\n");
                total += drink.getPrice();
            }

            // If the customer ordered chips, add to the receipt and update total
            if (chips != null) {
                receipt.append("Chips: ").append(chips.getFlavor()).append("\n");
                total += chips.getPrice();
            }

            // Add the total price of the entire order to the receipt
            receipt.append("Total Order Price: $").append(String.format("%.2f", total));

            // Print the receipt to the console
            System.out.println(receipt);

            // Save to file
            try {
                // Create a unique file name with current date and time
                String fileName = "resources/receipts/receipt-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

                // Open the file and write the receipt content
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                writer.write(receipt.toString());
                writer.close();

                // Confirm that the receipt was saved
                System.out.println("Receipt saved to " + fileName);
            } catch (IOException e) {
                // If something goes wrong with saving, show an error message
                System.out.println("Failed to save receipt: " + e.getMessage());
            }
        }
    }
