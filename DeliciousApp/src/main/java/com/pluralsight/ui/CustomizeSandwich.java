package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.util.Scanner;

import static com.pluralsight.util.UiHelper.*;


public class CustomizeSandwich {
    public Sandwich build() {
        Scanner myScanner = new Scanner(System.in);

        // Get bread and size

        //============================ BREAD ============================
        String bread;
        while (true) {
            System.out.print("Choose bread (White/Wheat/Rye/Wrap): ");
            bread = myScanner.nextLine().trim().toLowerCase();
            if (bread.matches("white|wheat|rye|wrap")) break;
            System.out.println("Invalid choice. Try again.");
        }

        String sizeChoice;
        while (true) {
            System.out.print("Enter the size you want (4/8/12): ");
            sizeChoice = myScanner.nextLine().trim();
            if (sizeChoice.matches("4|8|12")) break;
            System.out.println("Invalid size. Try again.");
        }

        // Ask if toasted
        boolean toasted = false;
        System.out.print("Would you like it toasted? Enter Y to toast: ");
        String toastedInput = myScanner.nextLine().trim();
        if (toastedInput.equalsIgnoreCase("Y")) {
            toasted = true;
        } else {
            System.out.println("Skipping toasted option...");
        }

        // Create sandwich object
        Sandwich sandwich = new Sandwich(bread, sizeChoice, toasted);

        if (!confirmStep(myScanner, sandwich)) return null;


        //============================ MEAT ============================
        System.out.println("\nMeats (Premium Toppings):");
        showLoadingSpinner(1000);
        System.out.println("- steak, ham, salami, roast beef, chicken, bacon");
        showLoadingSpinner(1000);
        System.out.println("Base Prices: $1.00 $2.00 $3.00");
        showLoadingSpinner(1000);
        System.out.println("Extra Meat: $0.50 $1.00 $1.50");

        System.out.println("Would you like to add meat? (Y): or press Enter to skip: ");
        if (myScanner.nextLine().trim().equalsIgnoreCase("Y")) {

            String[] meats;
            while (true) {
                System.out.print("Enter meats - steak, ham, salami, roast beef, chicken, bacon (use comma please): ");
                String meatInput = myScanner.nextLine().trim().toLowerCase();
                meats = meatInput.split(",");
                boolean allValid = true;

                for (String meat : meats) {
                    String m = meat.trim();
                    if (!m.matches("steak|ham|salami|roast beef|chicken|bacon")) {
                        System.out.println("Invalid meat: '" + m + "'. Try again.");
                        allValid = false;
                        break;
                    }
                }

                if (allValid) break; // Exit loop only if all meats are valid
            }

            // Get valid size
            while (true) {
                System.out.print("Enter the size you want (4/8/12): ");
                sizeChoice = myScanner.nextLine().trim();
                if (sizeChoice.matches("4|8|12")) break;
                System.out.println("Invalid size. Try again.");
            }

            // Ask if extra meat
            boolean isExtra = false;
            System.out.print("Do you want extra meat? (Y/N): ");
            String meatInput = myScanner.nextLine().trim();
            if (meatInput.equalsIgnoreCase("Y")) {
                isExtra = true;
            } else {
                System.out.println("Skipping extra meat option...");
            }

            // Process each valid meat
            for (String meat : meats) {
                String meatType = meat.trim().toLowerCase();
                if (!meatType.isEmpty()) {
                    Meat topping = new Meat(meatType, sizeChoice); // use sizeChoice here
                    topping.setExtra(isExtra);
                    sandwich.addMeats(topping);
                }
            }

            // Confirm sandwich
            if (!confirmStep(myScanner, sandwich)) return null;
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
        if (!confirmStep(myScanner, sandwich)) return null;


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
        if (!confirmStep(myScanner, sandwich)) return null;



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
        if (!confirmStep(myScanner, sandwich)) return null;


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
        if (!confirmStep(myScanner, sandwich)) return null;

        // ============================ Printing Summary of Order ============================

        System.out.println(sandwich.getSummary());
        showLoadingSpinner(1000);
        System.out.println("Is this sandwich correct : Y");
        String userChoice = myScanner.nextLine();
        if (!userChoice.equalsIgnoreCase("y")) {
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