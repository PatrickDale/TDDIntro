package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by patdale on 7/21/15.
 */
public class Account {
    private int balance = 0;

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }
}
