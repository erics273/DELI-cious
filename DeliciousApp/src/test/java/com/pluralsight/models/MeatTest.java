package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeatTest {

//test the price of meat with extra added.
    @Test
    public void testMeatPriceWithExtra() {
        Meat turkey = new Meat(8, true, 2, "Chicken");
        assertEquals(3, turkey.getPrice(), 0.01); // base + $1
    }
// Test the meat class without extra added.
    @Test
    public void testMeatPriceWithoutExtra() {
        Meat ham = new Meat(4, false, 1.00, "Ham");
        assertEquals(1.00, ham.getPrice(), 0.01); // no extra
    }
}