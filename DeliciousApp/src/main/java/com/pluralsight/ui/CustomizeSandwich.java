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
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print(" Choose bread (White/Wheat/Rye/Wrap):\n ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            bread = myScanner.nextLine().trim().toLowerCase();
            if (bread.matches("white|wheat|rye|wrap")) break;


            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Invalid choice. Try again.");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        }

        String sizeChoice;
        while (true) {
            System.out.print("Enter the size you want (4/8/12):\n ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            sizeChoice = myScanner.nextLine().trim();
            if (sizeChoice.matches("4|8|12")) break;
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Invalid size. Try again.");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        }

        // Ask if toasted
        boolean toasted = false;
        System.out.print("Would you like it toasted? Enter Y to toast: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String toastedInput = myScanner.nextLine().trim();
        if (toastedInput.equalsIgnoreCase("Y")) {
            toasted = true;
        } else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Skipping toasted option...");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        }

        // Create sandwich object
        Sandwich sandwich = new Sandwich(bread, sizeChoice, toasted);

        if (!confirmStep(myScanner, sandwich)) return null;


        //============================ MEAT ============================
        System.out.println("********************************");
        System.out.println("\nMeats (Premium Toppings):");
        System.out.println("********************************");

        showLoadingSpinner(1000);

        System.out.println("- steak, ham, salami, roast beef, chicken, bacon");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        showLoadingSpinner(1000);
        System.out.println("Base Prices: $1.00 $2.00 $3.00");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        showLoadingSpinner(1000);
        System.out.println("Extra Meat: $0.50 $1.00 $1.50");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Would you like to add meat? (Y): or press Enter to skip: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String meatChoice = myScanner.nextLine().trim();
        showLoadingSpinner(1000);

        if (!meatChoice.equalsIgnoreCase("Y")) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("You didn't choose your Meat. Would you like to try again? Press Y for Yes:");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            String meatRetry = myScanner.nextLine().trim();
            showLoadingSpinner(1000);

            if (!meatRetry.equalsIgnoreCase("Y")) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Skipping meat ...");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                showLoadingSpinner(100);

            } else {
                String[] meats;
                while (true) {
                    showLoadingSpinner(1000);
                    System.out.print("Enter meats - steak, ham, salami, roast beef, chicken, bacon (use comma please): ");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                    String meatInput = myScanner.nextLine().trim().toLowerCase();
                    showLoadingSpinner(1000);

                    meats = meatInput.split(",");
                    boolean allValid = true;

                    for (String meat : meats) {
                        String m = meat.trim().toLowerCase();
                        if (!m.matches("steak|ham|salami|roast beef|chicken|bacon")) {

                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            System.out.println("Invalid meat: '" + m + "'. Try again.");
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            allValid = false;
                            break;
                        }
                    }

                    if (allValid) break; // Exit loop only if all meats are valid
                }


                // Get valid size
                while (true) {
                    showLoadingSpinner(1000);
                    System.out.print("Enter the size you want (4/8/12): ");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                    sizeChoice = myScanner.nextLine().trim();
                    showLoadingSpinner(1000);

                    if (sizeChoice.matches("4|8|12")) break;

                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Invalid size. Try again.");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                }

                // Ask if extra meat
                boolean isExtra = false;
                System.out.println("********************************");
                System.out.print("Do you want extra meat? (Y/N): ");
                System.out.println("********************************");

                String meatInput = myScanner.nextLine().trim();
                showLoadingSpinner(1000);

                if (meatInput.equalsIgnoreCase("Y")) {
                    isExtra = true;
                } else {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Skipping extra meat ...");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

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
        }

        //============================ CHEESE ============================
        System.out.println("********************************");
        System.out.println("\nCheese (Premium Toppings):");
        System.out.println("********************************");

        showLoadingSpinner(1000);
        System.out.println("- american, provolone, cheddar, swiss");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        showLoadingSpinner(1000);
        System.out.println("Base Prices: $0.75 $1.50 $2.25");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        showLoadingSpinner(1000);
        System.out.println("Extra Cheese: $0.30 $0.60 $0.90");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Would you like to add cheese? (Y): or press Enter to skip: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        //Accept user input
        String cheeseAnswer = myScanner.nextLine().trim();
        showLoadingSpinner(1000);


        //validation for input
        if (!cheeseAnswer.equalsIgnoreCase("Y")) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("You didn't choose your Cheese. Would you like to try again? Press Y for Yes:");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            String cheeseRetry = myScanner.nextLine().trim();
            showLoadingSpinner(1000);

            if (!cheeseRetry.equalsIgnoreCase("Y")) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Skipping Cheese ...");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                showLoadingSpinner(100);
            }

            if (cheeseRetry.equalsIgnoreCase("Y")) {
                String[] cheeses;
                while (true) {
                    System.out.print("Enter Cheese - American, Provolone, Cheddar, Swiss (use comma please): ");
                    String cheeseInput = myScanner.nextLine().trim().toLowerCase();
                    showLoadingSpinner(1000);

                    cheeses = cheeseInput.split(",");
                    boolean allValid = true;

                    for (String cheese : cheeses) {
                        String c = cheese.trim().toLowerCase();
                        if (!c.matches("American|america|a|A Provolone|provolone Cheddar|cheddar| s|Swiss|swiss")){

                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            System.out.println("Invalid Cheese: '" + c + "'. Try again.");
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                            allValid = false;
                            break;
                        }
                    }

                    if (allValid) break; // Exit loop only if all meats are valid
                }

                // Get valid size
                while (true) {
                    System.out.print("Enter the size you want (4/8/12): ");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                    sizeChoice = myScanner.nextLine().trim();
                    showLoadingSpinner(1000);

                    if (sizeChoice.matches("4|8|12")) break;
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Invalid size. Try again.");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                }

                // Ask if extra meat
                boolean isExtra = false;
                System.out.println("********************************");
                System.out.print("Do you want extra cheese? (Y/N): ");
                System.out.println("********************************");

                String cheeseExtra = myScanner.nextLine().trim();
                showLoadingSpinner(1000);


                //validation for extra input choice
                if (cheeseExtra.equalsIgnoreCase("Y")) {
                    isExtra = true;
                } else {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Skipping extra cheese ...");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                }

                // Process each valid meat
                for (String c : cheeses) {
                    String cheeseType = c.trim().toLowerCase();
                    if (!cheeseType.isEmpty()) {
                        Cheese topping = new Cheese(cheeseType); // use sizeChoice here
                        topping.setExtra(isExtra);
                        sandwich.addCheese(topping);
                    }
                }

                // Confirm sandwich
                if (!confirmStep(myScanner, sandwich)) return null;
            }
        }

        // ======================= REGULAR TOPPINGS (Included) =======================

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nRegular Toppings (Included, no extra charge):");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        showLoadingSpinner(1000);
        System.out.println("- lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        showLoadingSpinner(1000);

        String[] toppings;
        boolean toppingsAdded = false;  // Track if any toppings were added
        while (true) {
            System.out.print("Enter your toppings - lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms (use comma please) : ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            //take user input
            String regularInput = myScanner.nextLine().trim().toLowerCase();
            showLoadingSpinner(1000);


            //input validation
            if (!regularInput.isEmpty()) {
                toppings = regularInput.split(",");
                boolean allValid = true;
                for (String t : toppings) {//
                    String toppingType = t.trim();
                    if (!toppingType.matches("lettuce| peppers| onions| tomatoes| jalapeños| cucumbers| pickles| guacamole| mushrooms")) {

                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("Invalid Cheese: '" + toppingType + "'. Try again.");
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                        allValid = false;
                        break;
                    }
                }

                if (allValid) {
                    for (String t : toppings) {
                        Topping topping = new Topping(t.trim().toLowerCase()); // Regular topping
                        sandwich.addTopping(topping);
                    }
                    toppingsAdded = true;
                    break;
                }

            } else {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("You didn't choose your free toppings.would you like to try again?\n press Y for Yes");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                //Accept user input
                String toppingInput = myScanner.nextLine().trim().toLowerCase();
                showLoadingSpinner(1000);


                //validation for input
                if (toppingInput.equalsIgnoreCase("Y")) {
                    continue;
                }else{
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Skipping Topping...");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                    showLoadingSpinner(100);
                    break;
                }
            }
            if (!confirmStep(myScanner, sandwich)) return null;
        }


        //============================ Sauces (Included) ============================
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(" Sauces (Included): Mayo, Mustard, Ketchup, Ranch, Thousand Island, Vinaigrette");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        showLoadingSpinner(1000);

        System.out.print("Enter sauces you want (Use comma please)  or press Enter to skip : ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String saucesInput = myScanner.nextLine().trim().toLowerCase();
        showLoadingSpinner(1000);


        if (!saucesInput.equalsIgnoreCase("Y")) {

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("You didn't choose your free Sauces. Would you like to try again? Press Y for Yes:");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            String sauceRetry = myScanner.nextLine().trim().toLowerCase();
            showLoadingSpinner(1000);


            if (!sauceRetry.equalsIgnoreCase("Y")) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Skipping Cheese ...");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                showLoadingSpinner(100);
            }
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

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" Sides (Included): Au Jus, Sauce");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            System.out.print("Enter sides you want (Use comma please)  or press Enter to skip: ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            String sidesInput = myScanner.nextLine().trim().toLowerCase();
            showLoadingSpinner(1000);


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
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Is this sandwich correct : Y");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            String userChoice = myScanner.nextLine();
            showLoadingSpinner(1000);

            if (!userChoice.equalsIgnoreCase("y")) {
                return null;
            }
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