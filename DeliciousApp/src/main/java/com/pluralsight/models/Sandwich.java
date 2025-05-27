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

    }

    //   - set base price based on size

    // addMeat method:
    // add meat(s)
    public void addMeats(Meat item) {
        meats.add(item);
    }

    // what is the price based on size and whether it's extra?
    public double getPrice() {
        double total = 0;
        for (Meat m : meats) {//foreach(no need to know the index) item in the list called meats from the meat class store it in m.
            total += m.getPrice();// Then get the price that is in m(Arraylist) => collect/Add the price only and  store it in a total box.
        }
        return total;
    }
}

// addCheese method:
//   - add cheese(s)
//   - add price depending on size and whether it's extra

// addTopping method:
//   - add topping(s)
//   - no charge

// addSauce method:
//   - add sauce(s)
//   - no charge

// getPrice method:
//   - return current total price

// getSummary method:
//   - return a string with all sandwich details and price

//Makes a sandwich	You pick your sandwich and save what’s on it




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