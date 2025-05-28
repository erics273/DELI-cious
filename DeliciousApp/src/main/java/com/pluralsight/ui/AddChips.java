package com.pluralsight.ui;

import com.pluralsight.models.Chips;

import java.util.Scanner;

public class AddChips {

    public Chips getChips() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Would you like chips? (yes/no): ");

        if (scanner.nextLine().equalsIgnoreCase("yes")) {

            System.out.print("Enter chip flavor: ");
            String flavor = scanner.nextLine();

            Chips myChips = new Chips(flavor);

            return myChips;
        }
        return null;
    }
}

