package com.pluralsight.models;

public class Chips {

    private double price;


    public Chips(double price) {
        this.price = price;
    }

    public double getPrice() {
        return 1.50;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
/* package com.pluralsight.finance;

public class BankAccount implements Valuable {

    private String name;
    private String accountNumber;
    private double balance;

    public BankAccount(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Custom Method deposit(double  ), withdraw(double )
    @Override
    public double getValue() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount; // add money
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount; // take money out
        }
    }
// Generate getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
   */
