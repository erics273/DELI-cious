package com.pluralsight.models;

public class Cheese {

    //set the attributes for Cheese.

    private String type;
    private String size;
    private double price;
    private boolean isExtra;

    //Generate constructor

    public Cheese(String size, String type, double price, boolean isExtra) {
        this.size = size;
        this.type = type;
        this.price = price;
        this.isExtra = isExtra;
    }

    //generate getter and setter

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        // Adjust price only if it's extra
        double finalPrice = price;
        if (this.isExtra && this.size == "4") {
            finalPrice += 0.30; // Add $0.30 if customer wants extra meat size 4".
        }
        if (this.isExtra && this.size == "8") {
            finalPrice += 0.60; // Add $0.60 if customer wants extra meat size 8".
        }
        if (this.isExtra && this.size == "12") {
            finalPrice += 0.90; // Add $0.90 if customer wants extra meat size 12".
        }

        return finalPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }
}
