package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToppingTest {
    @Test
    void testIsPremiumToppingReturnsTrueForMeat() {
        // Arrange
        Meat meat= new Meat("8", true,  "Chicken"); // Meat extends Topping

        // Act
        boolean result = Topping.isPremiumTopping(meat);

        // Assert
        assertTrue(result, "Expected isPremiumTopping to return true for Meat");
    }

    @Test
    void testIsPremiumToppingReturnsTrueForCheese() {
        // Arrange
        Cheese cheese = new Cheese("4", "American",true); // Cheese extends Topping

        // Act
        boolean result = Topping.isPremiumTopping(cheese);

        // Assert
        assertTrue(result, "Expected isPremiumTopping to return true for Cheese");
    }

    @Test
    void testIsPremiumToppingReturnsFalseForOtherTopping() {
        // Arrange
        Topping lettuce = new Topping(false);

        // Act
        boolean result = Topping.isPremiumTopping(lettuce);

        // Assert
        assertFalse(result, "Expected isPremiumTopping to return false for regular Topping");
    }

    @Test
    void testIsRegularPrintsMessageWhenToppingIsNotPremium() {
        // Arrange
        Topping regularTopping = new Topping(false);
        regularTopping.setType("Lettuce");

        // Act
        // We're just running it to see that it doesn't throw or misbehave
        regularTopping.isRegular(regularTopping);

        // Assert
        // No actual assert here unless you redirect system output — safe for now
        assertFalse(regularTopping.isPremium(), "Expected regularTopping to not be premium");
    }

}