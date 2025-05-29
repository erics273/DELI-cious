package com.pluralsight.models;

import java.util.ArrayList;

public class Order {

    // create List for order items (sandwiches, drinks, and chips)
    //Saves all sandwiches, drinks, chips	A big tray where all our snacks go

    public ArrayList<Sandwich> sandwiches;
    public ArrayList<Chips> chips;
    public ArrayList<Drink> drinks;
    public double price; // store total price

    // constructor:
    //   - initialize the class properties

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.price = price;
    }


    // addSandwich method:
    //   - add sandwich to list
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    // addDrink method:
    //   - add drink to list
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    // addChips method:
    //   - add chips to list
    public void addChips(Chips chip) {
        chips.add(chip);
    }

    // getTotal method:
    //   - return total price of order

    // getSandwiches, getDrinks, getChips:
    //   - return the orders items

    // getOrderSummary method:
    //   - return formatted string of all items and total

}
