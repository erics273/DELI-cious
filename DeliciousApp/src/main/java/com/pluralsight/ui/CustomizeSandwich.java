package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.util.Scanner;

import static com.pluralsight.util.UiHelper.showLoadingSpinner;
import static com.pluralsight.util.UiHelper.waitForEnter;

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
        System.out.print("Would you like it toasted? Enter Y to toast: ");
        String toastInput = myScanner.nextLine();
        toasted = toastInput.equalsIgnoreCase("Y");

        // Create sandwich object
        Sandwich sandwich = new Sandwich(bread, sizeChoice, toasted);

        //validating and confirming the user choice
        System.out.println(sandwich.getSummary());
        System.out.println("Is this correct? Press \"Y\" to continue : ");
        String validInput = myScanner.nextLine();
        if (!validInput.equalsIgnoreCase("Y")) {
            return null;
        }

        //============================ MEAT ============================
        System.out.println("\nMeats (Premium Toppings):");
        showLoadingSpinner(2000);
        System.out.println("- steak, ham, salami, roast beef, chicken, bacon");
        showLoadingSpinner(2000);
        System.out.println("Base Prices: $1.00 $2.00 $3.00");
        showLoadingSpinner(2000);
        System.out.println("Extra Meat: $0.50 $1.00 $1.50");

        while (true) {

            System.out.println("Would you like to add meat? (Y): or press Enter to skip: ");
            String userInput = myScanner.nextLine();

            if (!userInput.equalsIgnoreCase("y")) {
                break; // Exit cheese loop
            }

            System.out.print("Enter meats (use comma please), or press Enter to skip: ");
            String meatInput = myScanner.nextLine();


            System.out.print("Do you want extra meat?\n (Y(Yes)/N(No): ");
            showLoadingSpinner(2000);
            boolean isExtra = myScanner.nextLine().equalsIgnoreCase("y");

            String[] meats = meatInput.split(",");
            for (String meat : meats) {
                String meatType = meat.trim().toLowerCase();
                if (!meatType.isEmpty()) {
                    Meat topping = new Meat(meatType, sandwich.getSize());
                    topping.setExtra(isExtra);
                    sandwich.addMeats(topping);
                }

            }
            System.out.println(sandwich.getSummary());
            System.out.println("Is this correct? Press \"Y\" to continue : ");
            validInput = myScanner.nextLine();
            if (!validInput.equalsIgnoreCase("Y")) {
                return null;
            }
            break;

        }

        //============================ CHEESE ============================
        System.out.println("\nCheese (Premium Toppings):");
        showLoadingSpinner(1000);
        System.out.println("- american, provolone, cheddar, swiss");
        showLoadingSpinner(1000);
        System.out.println("Base Prices: $0.75 $1.50 $2.25");
        showLoadingSpinner(1000);
        System.out.println("Extra Cheese: $0.30 $0.60 $0.90");

        while (true) {
            System.out.println("Would you like to add cheese? (Y): or press Enter to skip: ");
            String userInput = myScanner.nextLine();

            if (!userInput.equalsIgnoreCase("y")) {
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
                //1continue; // Restart cheese loop
            }

            System.out.print("Do you want extra cheese? (Y(Yes)/N(No)): ");
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
            break;
        }
        System.out.println(sandwich.getSummary());
        System.out.println("Is this correct? Press \"Y\" to continue : ");
        validInput = myScanner.nextLine();
        if(!validInput.equalsIgnoreCase("Y")){
            return null;
        }
        // ======================= REGULAR TOPPINGS (Included) =======================
        System.out.println("\nRegular Toppings (Included, no extra charge):");
        showLoadingSpinner(1000);
        System.out.println("- lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms");
        showLoadingSpinner(1000);
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
        System.out.println(sandwich.getSummary());
        System.out.println("Is this correct? Press \"Y\" to continue : ");
        validInput = myScanner.nextLine();
        if(!validInput.equalsIgnoreCase("Y")){
            return null;
        }

        //============================ Sauces (Included) ============================
        System.out.println(" Sauces (Included): Mayo, Mustard, Ketchup, Ranch, Thousand Island, Vinaigrette");
        showLoadingSpinner(1000);
        System.out.print("Enter sauces you want (Use comma please)  or press Enter to skip:: ");
        showLoadingSpinner(1000);
        String saucesInput = myScanner.nextLine();

        if (!saucesInput.trim().isEmpty()) {
            String[] sauces = saucesInput.split(",");
            for (String sauce : sauces) {
                if (!sauce.trim().isEmpty()) {
                    sandwich.addSauce(new Sauces(sauce));
                }
            }
        }
        System.out.println(sandwich.getSummary());
        System.out.println("Is this correct? Press \"Y\" to continue : ");
        validInput = myScanner.nextLine();
        if(!validInput.equalsIgnoreCase("Y")){
            return null;
        }
        //============================ Sides (Included) ============================

        System.out.println(" Sides (Included): Au Jus, Sauce");
        System.out.print("Enter sides you want (Use comma please)  or press Enter to skip:: ");
        String sidesInput = myScanner.nextLine();

        if (!sidesInput.trim().isEmpty()) {
            String[] sides = sidesInput.split(",");
            for (String side : sides) {
                if (!side.trim().isEmpty()) {
                    sandwich.addSides(new Sides(side));
                }
            }
        }
        System.out.println(sandwich.getSummary());
        System.out.println("Is this correct? Press \"Y\" to continue : ");
         validInput = myScanner.nextLine();
        if(!validInput.equalsIgnoreCase("Y")){
            return null;
        }
        // ============================ Printing Summary of Order ============================

        System.out.println(sandwich.getSummary());
        showLoadingSpinner(1000);
        System.out.println("Is this sandwich correct : Y");
        String userChoice = myScanner.nextLine();
        if(!userChoice.equalsIgnoreCase("y")){
            return null;
        }

        // ============================ RETURN FINAL SANDWICH ============================
        return sandwich;
    }
}
//System.out.println(sandwich.getSummary());
//        System.out.println("Is this correct? Press \"Y\" to continue : ");
//        String validInput = myScanner.nextLine();
//        if(!validInput.equalsIgnoreCase("Y")){
//            return null;
//        }make it a method  boolean that return null which false