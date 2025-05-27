package com.pluralsight.models;

public interface Topping {
    // Abstract method to be implemented by all classes that represent sandwich toppings=> regular and prem- price calculate size => get price and summary
    String getType();

    boolean isExtra();

    double getPrice();

    String getSize();

}
