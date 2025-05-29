package com.pluralsight.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    //Makes a file with sandwich food info	Like a grocery receipt
// Save to file
    public static void saveReceiptToFile(String receiptText) {
        // Create a unique file name with current date and time
        String fileName = "src/main/resources/receipts/receipt-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Open the file and write the receipt content
            writer.write(receiptText);
            writer.close();

            // Confirm that the receipt was saved
            System.out.println("Receipt saved to "+fileName);
        } catch(Exception e) {
            // If something goes wrong with saving, show an error message
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }
}









