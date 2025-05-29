package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.util.Scanner;

public class CustomizeSandwich {
    public Sandwich build() {
        Scanner myScanner = new Scanner(System.in);

        // Get bread and size
        System.out.print("Choose bread (White/Wheat/Rye/Wrap): ");
        String bread = myScanner.nextLine();

        System.out.print("Enter the size you want (4/8/12): ");
        String sizeChoice = myScanner.nextLine();

        // Ask if toasted
        boolean toasted = false;
        System.out.print("Would you like it toasted? (yes/no): ");
        String toastInput = myScanner.nextLine();
        toasted = toastInput.equalsIgnoreCase("yes");

        // Create sandwich object
        Sandwich sandwich = new Sandwich(bread, sizeChoice, toasted);

        //============================ MEAT ============================
        System.out.println("\nMeats (Premium Toppings):");
        System.out.println("- steak, ham, salami, roast beef, chicken, bacon");
        System.out.println("Base Prices: $1.00 $2.00 $3.00");
        System.out.println("Extra Meat: $0.50 $1.00 $1.50");

        System.out.print("Enter meats (use comma please), or press Enter to skip: ");
        String meatInput = myScanner.nextLine();

        if (!meatInput.isEmpty()) {
            System.out.print("Do you want extra meat?\n (Y(Yes)/N(No): ");
            boolean isExtra = myScanner.nextLine().equalsIgnoreCase("y");

            String[] meats = meatInput.split(",");
            for (String meat : meats) {
                String meatType = meat.trim().toLowerCase();
                if (!meatType.isEmpty()) {
                    Meat topping = new Meat(meatType);
                    topping.setExtra(isExtra);
                    sandwich.addMeats(topping);
                }
            }
        }

        //============================ CHEESE ============================
        System.out.println("\nCheese (Premium Toppings):");
        System.out.println("- american, provolone, cheddar, swiss");
        System.out.println("Base Prices: $0.75 $1.50 $2.25");
        System.out.println("Extra Cheese: $0.30 $0.60 $0.90");

        while (true) {
            System.out.println("Would you like to add cheese? (Y/N): ");
            String userInput = myScanner.nextLine();

            if (userInput.equalsIgnoreCase("n")) {
                break; // Exit cheese loop
            }

            // Ask for cheese size
            System.out.print("Enter cheese size (4/8/12): ");
            String cheeseSize = myScanner.nextLine();

            // Ask for cheese type
            System.out.println("Enter type of cheese (American, Provolone, Cheddar, Swiss):");
            String cheeseTypeInput = myScanner.nextLine();

            if (cheeseTypeInput.trim().isEmpty()) {
                System.out.println("You selected no cheese. Try again.");
                continue; // Restart cheese loop
            }

            System.out.print("Do you want extra cheese? (Y/N): ");
            String cheeseExtra = myScanner.nextLine();
            boolean isExtraCheese = cheeseExtra.equalsIgnoreCase("y");

            String cheeseType = cheeseTypeInput.trim().toLowerCase();

            switch (cheeseType) {
                case "american":
                case "provolone":
                case "cheddar":
                case "swiss":
                    sandwich.addCheese(new Cheese(cheeseSize, cheeseType, isExtraCheese));
                    break;
                default:
                    System.out.println("Invalid cheese type ignored: " + cheeseTypeInput);
                    break;
            }
        }
        // ======================= REGULAR TOPPINGS (Included) =======================
        System.out.println("\nRegular Toppings (Included, no extra charge):");
        System.out.println("- lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms");

        System.out.print("Enter your regular toppings (use comma please), or press Enter to skip: ");
        String regularInput = myScanner.nextLine();
        if (!regularInput.isEmpty()) {
            String[] toppings = regularInput.split(",");
            for (String t : toppings) {//
                String toppingType = t.trim();
                if (!toppingType.isEmpty()) {
                    Topping topping = new Topping(toppingType); // Regular topping
                    sandwich.addTopping(topping);
                }
            }
        }

        //============================ Sauces (Included) ============================
        System.out.println(" Sauces (Included): Mayo, Mustard, Ketchup, Ranch, Thousand Island, Vinaigrette");
        System.out.print("Enter sauces you want (Use comma please): ");
        String saucesInput = myScanner.nextLine();

        if (!saucesInput.trim().isEmpty()) {
            String[] sauces = saucesInput.split(",");
            for (String sauce : sauces) {
                if (!sauce.trim().isEmpty()) {
                    sandwich.addSauce(new Sauces(sauce));
                }
            }
        }
    //============================ Sides (Included) ============================

        System.out.println(" Sides (Included): Au Jus, Sauce");
        System.out.print("Enter sides you want (Use comma please): ");
        String sidesInput = myScanner.nextLine();

        if (!sidesInput.trim().isEmpty()) {
            String[] sides = sidesInput.split(",");
            for (String side : sides) {
                if (!side.trim().isEmpty()) {
                    sandwich.addSides(new Sides(side));
                }
            }
        }

    // ============================ RETURN FINAL SANDWICH ============================
        return sandwich;
    }
}
