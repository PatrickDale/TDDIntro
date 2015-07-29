package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by patdale on 7/21/15.
 */
public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }
    
    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        }
    }
}
