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

        // ============================ MEAT SECTION ============================

        System.out.print("Enter meat size (4/8/12): ");
        String meatSize = myScanner.nextLine();

        System.out.println("Enter type of meat(s) (Steak, Ham, Salami, Roast Beef, Chicken, Bacon) — use comma:");
        String meatTypeChoice = myScanner.nextLine();

        if (!meatTypeChoice.trim().isEmpty()) {

            System.out.print("Do you want Extra meat? (y/n): ");
            String meatExtra = myScanner.nextLine();
            boolean isExtraMeat = meatExtra.equalsIgnoreCase("y");

            // Split meats and loop through
            String[] meats = meatTypeChoice.split(",");
            for (String m : meats) {
                String meatType = m.trim().toLowerCase();

                // Only add valid meats
                switch (meatType) {
                    case "steak":
                    case "ham":
                    case "salami":
                    case "roast beef":
                    case "chicken":
                    case "bacon":
                        sandwich.addMeats(new Meat(meatSize, isExtraMeat, meatType));
                        break;
                    default:
                        System.out.println("Invalid meat type ignored: " + m.trim());
                        break;
                }
            }
        }

        // ============================ CHEESE SECTION ============================

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

        // =================== Toppings (Included) =====================

        System.out.println("Regular Toppings (Included): Lettuce, Peppers, Onions, Tomatoes, Jalapeños, Cucumber, Pickles, Guacamole, Mushrooms");
        System.out.print("Enter your toppings (use comma please): ");
        String toppingsInput = myScanner.nextLine();

        if (!toppingsInput.trim().isEmpty()) {

            String[] toppings = toppingsInput.split(",");
            for (String t : toppings) {//
                String toppingType = t.trim();
                if (!toppingType.isEmpty()) {
                    Topping topping = new Topping(false); // Regular topping
                    topping.setType(toppingType);
                    topping.isRegular(topping); // Show no-charge message and set price = 0
                    sandwich.addTopping(topping);
                }
            }
        }



        // =================== Sauces (Included) =====================
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

        // =================== Sides (Included) =====================
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
