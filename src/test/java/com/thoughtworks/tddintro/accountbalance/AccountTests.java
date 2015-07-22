package com.thoughtworks.tddintro.accountbalance;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    private Account account;

    @Before
    public void beforeEachTest() {
        this.account = new Account();
    }

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        this.account.setBalance(100);

        this.account.deposit(50);

        assertThat(this.account.getBalance(), is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        this.account.setBalance(100);

        this.account.withdraw(50);

        assertThat(this.account.getBalance(), is(50));
    }

//    @Test
//    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
//
//    }
}
