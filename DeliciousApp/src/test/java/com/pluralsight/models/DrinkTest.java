package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    public void testPriceBySize() {
        //Arrange
        Drink myDrink = new Drink("L", 0);

        //Act
        double actualPrice = myDrink.getPrice("l");

        //Assert
        assertEquals(3, actualPrice,0.01);
    }

}

