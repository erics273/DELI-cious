package com.pluralsight.ui;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;
import java.util.Scanner;

import static com.pluralsight.util.UiHelper.showLoadingSpinner;

public class HandleNewOrder {
    public void startOrder() {

        Order myOrder = new Order();
        //To make them available in all cases, declare them before
        Scanner myScanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            while (running) {
                System.out.println("==========================");
                System.out.println("   Welcome to DELI-cious  ");
                System.out.println("==========================");
                showLoadingSpinner(1000); // Show the user it's loading options

                // Display menu
                System.out.println("""
                        1. Add Sandwich
                        2. Add Drink
                        3. Add Chips
                        4. Checkout
                        0. Cancel Order
                        """);

                System.out.print("Choose an option (0-4): ");
                String userChoice = myScanner.nextLine().trim();

                showLoadingSpinner(500);//visual delay

                // Validate input: must be a number between 0 and 4
                while (!userChoice.matches("[0-4]")) {
                    System.out.print("Invalid input. Please enter 0, 1, 2, 3, or 4: ");
                    userChoice = myScanner.nextLine().trim();
                }

                switch (userChoice) {
                    case "1":
                        CustomizeSandwich sandwichBuilder = new CustomizeSandwich();// instantiate the object that build our sandwich.
                        Sandwich sandwich = sandwichBuilder.build();//we call the build method and store it in sandwich variable
                        if(sandwich ==  null){
                            break;
                        }
                        myOrder.addSandwich(sandwich);
                        System.out.println("Sandwich added!\n");
                        //System.out.println( myOrder.sandwiches.toString());
                        break;
                    case "2":
                        AddDrink drinkAdder = new AddDrink();
                        Drink drink = drinkAdder.getDrink();
                        myOrder.addDrink(drink);
                        showLoadingSpinner(2000);
                        System.out.println("Drink added!\n");
                        //System.out.println( myOrder.drinks.toString());
                        break;
                    case "3":
                        AddChips chipAdder = new AddChips();
                        Chips chips = chipAdder.getChips();
                        myOrder.addChips(chips);
                        System.out.println("Chips added!\n");
                        //System.out.println( myOrder.chips.toString());
                        break;
                    case "4":
                        // Validate order before proceeding
                        if (myOrder.getSandwiches().isEmpty() && myOrder.getDrinks().isEmpty() && myOrder.getChips().isEmpty() ) {
                            System.out.println(" You must add at least one item before checkout.");
                            break;
                        }
                        CheckOutAndPrint checkout = new CheckOutAndPrint();

                        // One receipt per sandwich (can be updated to group if needed) = this need update
                        for (Sandwich s : myOrder.getSandwiches()) {

                            // Check if we have drinks, if yes get the first one, else null
                            Drink d = myOrder.getDrinks().isEmpty() ? null : myOrder.getDrinks().get(0);
                            // Check if we have chips, if yes get the first one, else null
                            Chips c = myOrder.getChips().isEmpty() ? null : myOrder.getChips().get(0);
                            // Print receipt for this sandwich + drink + chips (if any)
                            checkout.printReceipt(s, d, c);
                        }

                        running = false;
                        break;
                    case "0":
                        System.out.println("Order cancelled. See you next time!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option"); //how to save the item user giving me into one order object or class
                        //add the user input to the order class
                }

            }
        }
    }
}

