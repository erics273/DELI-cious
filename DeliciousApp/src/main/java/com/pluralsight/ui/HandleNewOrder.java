package com.pluralsight.ui;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;

import java.util.Scanner;

public class HandleNewOrder {
    public void startOrder() {

        Order myOrder = new Order();

        boolean running = true;

        while (running) {

            System.out.println(" Here are your option : ");
            System.out.println("""
                            1,Add Sandwich
                            2,Add Drinks
                            3,Add Chips
                            4,Checkout
                            0,Cancel Order
                    """);

            Scanner myScanner = new Scanner(System.in);
            String userChoice = myScanner.nextLine();

            switch (userChoice) {
                case "1":
                    CustomizeSandwich sandwichBuilder = new CustomizeSandwich();
                    Sandwich sandwich = sandwichBuilder.build();
                    //myOrder.addSandwich(sandwich);
                    //System.out.println( myOrder.sandwiches.toString()1);
                    break;
                case "2":
                    AddDrink drinkAdder = new AddDrink();
                    Drink drink = drinkAdder.getDrink();
                    //myOrder.addDrink(drink);
                   // System.out.println( myOrder.drinks.toString());
                    break;
                case "3":
                    AddChips chipAdder = new AddChips();
                    Chips chips = chipAdder.getChips();
                    //1myOrder.addChips(chips);
                    //System.out.println( myOrder.chips.toString());
                    break;
                case "4":
//                CheckOutAndPrint checkout = new CheckOutAndPrint();
//                checkout.printReceipt(sandwich, drink, chips);
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option"); //how to save the item user giving me into one order object or class
                    //add the user input to the order class
            }

        }
    }
}
