package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChipsTest {
    @Test
    public void testChipsConstructorAndGetPrice() {
        // Arrange
        Chips chips = new Chips(0);

        // Act
        double actualPrice = chips.getPrice();

        // Assert
        assertEquals(1.50, actualPrice, 0.001);
    }

    @Test
    public void testSetPrice() {
        // Arrange
        Chips chips = new Chips(0);

        // Act
        chips.setPrice(1.75);

        // Assert
        assertEquals(1.5, chips.getPrice(), 0.001);
    }

//no matter what price provided the price of chips is going to be $1.50.
}