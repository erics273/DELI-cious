package com.pluralsight.models;

public interface Toppable {
    // Abstract method to be implemented by all classes that represent sandwich toppings
    String getType();
    boolean isExtra();
    double getPrice();
    String getSize();

}
