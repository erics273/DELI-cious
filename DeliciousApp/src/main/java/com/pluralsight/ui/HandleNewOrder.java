package com.pluralsight.ui;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Sandwich;

public class HandleNewOrder {
    public void startOrder() {
        CustomizeSandwich sandwichBuilder = new CustomizeSandwich();
        Sandwich sandwich = sandwichBuilder.build();

        AddDrink drinkAdder = new AddDrink();
        Drink drink = drinkAdder.getDrink();

        AddChips chipAdder = new AddChips();
        Chips chips = chipAdder.getChips();

        CheckOutAndPrint checkout = new CheckOutAndPrint();
        checkout.printReceipt(sandwich, drink, chips);
    }
}
