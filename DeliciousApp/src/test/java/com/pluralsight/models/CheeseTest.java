package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheeseTest {

    //test the price of Cheese with extra added.
    @Test
    public void testCheesePriceWithExtra() {
        //Arrange
        Cheese cheddar = new Cheese("8", "Cheddar", 1.50, true );
        //Act
        double actualPrice = cheddar.getPrice();
        //Assert
        assertEquals(2.1, actualPrice, 0.01); // with extra
    }

    // Test the Cheese class without extra added.
    @Test
    public void testCheesePriceWithoutExtra() {
        //Arrange
       Cheese american = new Cheese("4","American", 0.75, false);
        //Act
        double actualPrice = american.getPrice();
        //Assert
        assertEquals(0.75, actualPrice, 0.01); // no extra
    }

}