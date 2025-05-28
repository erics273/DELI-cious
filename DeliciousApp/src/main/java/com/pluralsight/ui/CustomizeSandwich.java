package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.util.Scanner;

public class CustomizeSandwich {
    public Sandwich build() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose bread (White/Wheat/Rye/Wrap): ");
        String bread = scanner.nextLine();

        System.out.print("Enter size (4/8/12): ");
        String size = scanner.nextLine();

        boolean toasted = false;
        System.out.print("Toasted? (yes/no): ");
        String toastInput = scanner.nextLine();
        toasted = toastInput.equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(bread, size, toasted);

//        // Ask and add meat
//        System.out.print("Add meat (comma-separated or none): ");
//        String[] meats = scanner.nextLine().split(",");
//        for (String type : meats) {
//            type = type.trim(); // remove spaces
//            if (!type.isEmpty()) {
//                sandwich.addMeats(new Meat(type)); // create Meat object and add
//            }
//        }
//
// Ask and add cheese
//        System.out.print("Add cheese (comma-separated or none): ");
//        String[] cheeses = scanner.nextLine().split(",");
//        for (String t : cheeses) {
//            t = t.trim();
//            if (!t.isEmpty()) {
//                sandwich.addCheese(new Cheese(t.getType));
//            }
//
//            System.out.print("Add toppings (comma-separated or none): ");
//            for (String type : scanner.nextLine().split(",")) {
//                if (!type.trim().isEmpty()) sandwich.addTopping(new Topping(type.trim()));
//            }
//
//            System.out.print("Add sauces (comma-separated or none): ");
//            for (String type : scanner.nextLine().split(",")) {
//                if (!type.trim().isEmpty()) sandwich.addSauce(new Sauces(type.trim()));
//            }
//
//            return sandwich;
//        }
//    }

    }
}
