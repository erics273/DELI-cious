package com.pluralsight;

import com.pluralsight.ui.UserInterface;

import static com.pluralsight.util.UiHelper.showLoadingSpinner;

public class SandwichShopApp {
    public static void main(String[] args) {
        //Runs/Fire our app by asking and displaying the menu Home screen that asks what you want to do?
        System.out.println("Hello Wonderfully Customer !!!");
        showLoadingSpinner(2000);

        UserInterface ui = new UserInterface();
        ui.homeScreen();



    }
}
