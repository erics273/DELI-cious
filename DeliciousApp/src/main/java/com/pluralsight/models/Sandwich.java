package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich {

    //Set attribute for sandwich class
    private String breadType;// store bread type (white, wheat, rye, wrap)
    private String size;// store sandwich size (4, 8, or 12 inches)
    private boolean isToasted;// store if sandwich is toasted
    private ArrayList<Meat> meats; //store meats
    private ArrayList<Cheese> cheeses; //store Cheeses
    private ArrayList<Topping> toppings;// store toppings
    private ArrayList<Sauces> sauces; // store sauces
    private ArrayList<Sides> sides;
    private double price;// keep track of total price


    // constructor: takes bread type, size, toasted

    public Sandwich(String breadType, String size, boolean isToasted) {

        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;

        //initialize the list to be new list.

        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.sides = new ArrayList<>();

    }

    // addMeat/Cheese/Topping/Sauce method:

    public void addMeats(Meat meat) {
        meats.add(meat);// add meat(s)
    }

    public void addCheese(Cheese cheese) {
        cheeses.add(cheese);// add cheese(s)
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);// add topping(s)
    }

    public void addSauce(Sauces sauce) {
        sauces.add(sauce);// add sauce(s)
    }
    public void addSides(Sides side){
        sides.add(side);
    }

    // The price based on size and whether it's extra?
    public double getPrice() {
        double total = 0;

        for (Meat meat : meats) {
            total += meat.getPrice();
        }

        for (Cheese cheese : cheeses) {
            total += cheese.getPrice();
        }

        for (Topping topping : toppings) {
            // if toppings also return price
            total += topping.getPrice();
        }

        //Sauces are free, so not added to total

        return total;
    }

    // getSummary method
//   returns a string with sandwich details and total price
    public String getSummary() {

        // Use StringBuilder for efficient string concatenation
        StringBuilder summary = new StringBuilder();//word collecting basket

        // Start with a header
        summary.append("Sandwich Summary:\n");//add to it by using append

        // Add bread type, size, and toast preference
        summary.append("Bread: " + breadType + "\n");
        summary.append("Size: " + size + "\n");
        summary.append("Toasted: " + (isToasted ? "Yes" : "No") + "\n");


        // List all meats in the sandwich
        summary.append("Meats: ");
        for (Meat m : meats)
            summary.append(m.getType() + ", ");

        // List all cheeses in the sandwich
        summary.append("\nCheeses: ");
        for (Cheese c : cheeses)
            summary.append(c.getType() + ", ");

        // List all regular or premium toppings
        summary.append("\nToppings: ");
        for (Topping t : toppings)
            summary.append(t.getType() + ", ");

        // List all sauces (free)
        summary.append("\nSauces: ");
        for (Sauces s : sauces)
            summary.append(s.getType() + ", ");

        // List all sides (free)
        summary.append("\nSides: ");
        for(Sides s : sides)
            summary.append(s.getType() + ", ");

        // get the price of the sandwich
        double price = getPrice();

        // format the price to 2 decimal places
        String formattedPrice = String.format("%.2f", price);

        // add the total price to the summary text
        summary.append("\nTotal Price: $" + formattedPrice);

        return summary.toString();//turn all the words into one readable sentence by using toString() and return it.

    }

}

