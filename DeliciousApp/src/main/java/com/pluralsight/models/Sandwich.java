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
    private ArrayList<Sauces> sauces; // list of sauces
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
        StringBuilder summary = new StringBuilder();
        summary.append("Sandwich Summary:\n");
        summary.append("Bread: " + breadType + "\n");
        summary.append("Size: " + size + "\n");
        summary.append("Toasted: " + (isToasted ? "Yes" : "No") + "\n");

        summary.append("Meats: ");
        for (Meat m : meats)
            summary.append(m.getType() + ", ");

        summary.append("\nCheeses: ");
        for (Cheese c : cheeses)
            summary.append(c.getType() + ", ");

        summary.append("\nToppings: ");
        for (Topping t : toppings)
            summary.append(t.getType() + ", ");

        summary.append("\nSauces: ");
        for (Sauces s : sauces)
            summary.append(s.getType() + ", ");

        summary.append("\nTotal Price: $" + String.format("%.2f", getPrice()));

        return summary.toString();
    }

}


/*

    //Custom method  toString method show us error on mistake, make the code safe/clean, easy to read/understand when other want what my object is.
    @Override
    public String toString() {
        return "Vehicle{" +
                "vin : " + vin +
                ", year : " + year +
                ", make : " + make + '\'' +
                ", model : " + model + '\'' +
                ", type : " + type + '\'' +
                ", color : " + color + '\'' +
                ", odometer : " + odometer +
                ", price : " + price +
                '}';
    }

*/