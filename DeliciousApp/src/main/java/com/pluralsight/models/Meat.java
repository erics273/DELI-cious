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

    public double getPrice(String size,boolean isExtra) {

        if(size == "4" && isExtra){
            this.price += 1;
        }
        return price;

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
