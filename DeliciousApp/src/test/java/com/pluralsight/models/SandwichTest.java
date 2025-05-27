package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SandwichTest {

    @Test
    public void testAddMeatAndGetPriceWithoutExtra() {
        // Arrange
        Sandwich sandwich = new Sandwich("white", "4", false);
        Meat meat = new Meat("4", false, 1.50, "Ham");

        // Act
        sandwich.addMeats(meat);
        double total = sandwich.getPrice();

        // Assert
        assertEquals(1.50, total, 0.01); // no extra charge
    }

    @Test
    public void testAddMeatAndGetPriceWithExtra_4inch() {
        // Arrange
        Sandwich sandwich = new Sandwich("white", "4", false);
        Meat meat = new Meat("4", true, 1.50, "Turkey");

        // Act
        sandwich.addMeats(meat);
        double total = sandwich.getPrice();

        // Assert
        assertEquals(2.00, total, 0.01); // $1.50 + $0.50 extra
    }

    @Test
    public void testAddMultipleMeatsWithAndWithoutExtra() {
        // Arrange
        Sandwich sandwich = new Sandwich("wheat", "8", true);
        Meat meat1 = new Meat("8", true, 2.00, "Chicken");
        Meat meat2 = new Meat("8", false, 1.50, "Ham");

        // Act
        sandwich.addMeats(meat1);
        sandwich.addMeats(meat2);
        double total = sandwich.getPrice();

        // Assert
        assertEquals(4.50, total, 0.01); // $2.00 + $1.00 extra + $1.50
    }

}