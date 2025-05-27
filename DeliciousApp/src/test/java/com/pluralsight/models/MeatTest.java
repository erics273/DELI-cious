package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeatTest {

    //test the price of meat with extra added.
    @Test
    public void testMeatPriceWithExtra() {
        //Arrange
        Meat chicken = new Meat("8", true, 2, "Chicken");
        //Act
        double actualPrice = chicken.getPrice();
        //Assert
        assertEquals(3, actualPrice, 0.01); // base + $1
    }

    // Test the meat class without extra added.
    @Test
    public void testMeatPriceWithoutExtra() {
        //Arrange
        Meat ham = new Meat("4", false, 1.00, "Ham");
        //Act
        double actualPrice = ham.getPrice();
        //Assert
        assertEquals(1.00, actualPrice, 0.01); // no extra
    }
}