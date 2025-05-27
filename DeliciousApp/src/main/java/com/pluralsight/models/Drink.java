package com.pluralsight.models;

public class Drink {

    private String size;
    private double price;


    public Drink(String size, double price) {
        this.size = size;
        this.price = price;
    }

    public String getSize(String size) {
        return size;
    }

    public void setSize() {
        this.size = size;
    }

    public double getPrice(String size) {
        return switch (size.toLowerCase()) {
            case "s" -> 2.00;
            case "m" -> 2.50;
            case "l" -> 3.00;
            default -> 0;
        };
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
/*List<MyItem> items = List.of(item1, item2, item3);

List<MyItem> premiumItems = items.stream()
  .filter(i -> i.getPrice("m") > 2.00)
   .collect(Collectors.toList());*/

