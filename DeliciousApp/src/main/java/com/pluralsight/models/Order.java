package com.pluralsight.models;

import java.util.ArrayList;

public class Order {

//Saves all sandwiches, drinks, chips	A big tray where all our snacks go
private ArrayList<Sandwich> sandwiches;
private ArrayList<Chips> chips;
private ArrayList<Drink> drinks;







}
/*package com.pluralsight;

import com.pluralsight.finance.*;//*

import java.util.ArrayList;

public class Portfolio implements Valuable{
    //collection of valuable creating a list and hold all of it.
    //Create
    // List of valuables (house, gold, credit card, etc.)

    //Set property of our Portfolio class it's a List. It makes sure every asset it holds implement the interface.
    // Guarantee that my items on my list valuables implement the interface that is why we declare the type to be interface.
    //Help me to access getValue() directly without calling the class that implement it.

    private ArrayList<Valuable> valuables;

    //Generate constructor
    public Portfolio() {
        this.valuables = new ArrayList<>();//initializing the list to be new list.
    }


    //Custom Method
    // Add item to portfolio list

    public void addValuable(Valuable item) {
        valuables.add(item);
    }

    // Calculate total value (bank + house - credit card) => get the net value
    public double getValue() {
        double total = 0;
        for (Valuable v : valuables) {//foreach(no need to know the index) item in the list called valuables that implement the Valuable interface class store it in v.
            total += v.getValue();// Then get the value that are in v and collect/Add only them and store it as a total.
        }
        return total;
    }

    // Method to show/display  each item’s value
    public void showValuables() {
        for (Valuable v : valuables) {
            System.out.println("Item value: " + v.getValue());
        }
    }

    //Exercise getLeast and most method

    public Valuable getMostValuables() {

        //validation to print null if the list is empty
        if(valuables.isEmpty()){
            return null;
        }
        //from my list first get the first value to start the comparison and store it in box called most
       Valuable most = valuables.get(0);

        //Then loop through the list to and compare line the item in order
        for (Valuable v : valuables) {
            //set a condition to start to compare
            if(v.compareTo(most) > 0 ){
               most = v;
            }
        }
        return most;
    }

    public Valuable getLeastValuables() {
        //validation to print null or return 0 if the list is empty
        if(valuables.isEmpty()){
            return null;
        }
        //from my list first get the first value of the first item  to start the comparison and store it in box called least.
        Valuable least = valuables.get(0);

        //Then loop through the list to compare it with our least box to line the item in order
        for (Valuable v : valuables) {
            if(v.compareTo(least) < 0){
                 least = v;
            }
        }
        return least;
    }

    @Override
    public String toString() {
        return "Amount $: " + valuables;
    }
    //this built in method that Griffin showed and AI search.
// return Collections.max(valuables, Comparator.comparing(Valuable::getValue));
// return Collections.min(valuables, Comparator.comparing(Valuable::getValue));
}
   */