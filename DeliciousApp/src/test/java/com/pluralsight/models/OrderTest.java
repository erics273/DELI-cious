package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    public void testAddChipsAndDrinkAndCalculateTotal() {
        // Create an Order instance
        Order order = new Order();

        // Create and add Chips to order
        Chips chips = new Chips("Salt & Vinegar");
        order.addChips(chips);

        // Create and add Drink to order
        Drink drink = new Drink("Medium", "Cola");
        order.addDrink(drink);

        // Optionally create a sandwich (assuming constructor with breadType, size, isToasted)
        Sandwich sandwich = new Sandwich("Wheat", "8", true);
        order.addSandwich(sandwich);

        // We need to set prices for the sandwich, chips, and drink for total calculation

        // Normally, price comes from getPrice(), which depends on model
        // For test, we can either mock or assume these prices:
        // Let’s say:
        // sandwich price: 7.00 (size 8 base price)
        // chips price: 1.50
        // drink price: 2.50 (medium size assumed)

        // But getPrice() depends on actual logic.
        // override getPrice() in Sandwich, Chips, Drink or set price manually
        // Here, we assume getPrice() works correctly

        // Calculate total price via Order method
        double total = order.getTotal();

        // Expected price calculation:
        // Sandwich base price for size "8" is 7.00 (from your Sandwich class switch-case)
        double expectedSandwichPrice = 7.00;
        double expectedChipsPrice = 1.50;
        double expectedDrinkPrice = 2.50;

        double expectedTotal = expectedSandwichPrice + expectedChipsPrice + expectedDrinkPrice;

        // Assert total is close to expectedTotal (with small delta for floating point)
        assertEquals(expectedTotal, total, 0.01);

        // Assert the items were added properly
        assertTrue(order.getChips().contains(chips));
        assertTrue(order.getDrinks().contains(drink));
        assertTrue(order.getSandwiches().contains(sandwich));

        // Optional: check order summary contains correct info
        String summary = order.getOrderSummary();
        assertTrue(summary.contains("Salt & Vinegar"));
        assertTrue(summary.contains("Cola"));
        assertTrue(summary.contains("Wheat"));
        assertTrue(summary.contains(String.format("%.2f", expectedTotal)));
    }

}