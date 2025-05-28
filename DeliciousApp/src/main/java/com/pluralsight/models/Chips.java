package com.pluralsight.models;

public class Chips {

    //Set attribute
    private static final double PRICE = 1.50;// the price is fixed and set.
    private String flavor;

    //Generate constructor
    public Chips(String flavor) {

        this.flavor = flavor;
    }

    //Generate getter and setter
    public double getPrice() {
        return PRICE;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}

