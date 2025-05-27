package com.pluralsight.models;

public class Meat {

    // Set attribute => what meat have!!
    private int size;
    private String type;//name
    private double price;
    private boolean isExtra;

    //Generate constructor

    public Meat(int size, boolean isExtra, double price, String type) {
        this.size = size;
        this.isExtra = isExtra;
        this.price = price;
        this.type = type;
    }

    //Generate getter and setter


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        // Adjust price only if it's extra
        double finalPrice = price;
        if (this.isExtra && this.size == 4) {
            finalPrice += 0.50; // Add $0.50 if customer wants extra meat size 4".
        }
        if (this.isExtra && this.size == 8) {
            finalPrice += 1.00; // Add $1 if customer wants extra meat size 8".
        }
        if (this.isExtra && this.size == 12) {
            finalPrice += 1.50; // Add $1.50 if customer wants extra meat size 12".
        }

        return finalPrice;

    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }
}
