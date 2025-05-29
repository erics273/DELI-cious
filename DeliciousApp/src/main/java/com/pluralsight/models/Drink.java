package com.pluralsight.models;

public class Drink {

    //Set attribute

    private String size;
    private double price;
    private String type;

    //Generate constructor

    public Drink(String size, String type) {
        this.size = size;
        this.type = type;

        this.price = calculatePriceFromSize(size); //Automatically set price based on size
    }

    //Custom Method

    public double calculatePriceFromSize(String size) {
        return switch (size.toLowerCase()) {
            case "s" -> this.price = 2.00;
            case "m" -> this.price = 2.50;
            case "l" -> this.price = 3.00;
            default -> this.price = 0;
        };
    }

    //Generate getter and setter.

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
        this.price = calculatePriceFromSize(size); // Update price when size changes
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "size='" + size + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }

}
/*List<MyItem> items = List.of(item1, item2, item3);

List<MyItem> premiumItems = items.stream()
  .filter(i -> i.getPrice("m") > 2.00)
   .collect(Collectors.toList());*/

