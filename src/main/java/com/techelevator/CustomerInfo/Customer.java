package com.techelevator.CustomerInfo;

public class Customer {
    private double balanceAmount = 20;

    public Customer(double balanceAmount){
        this.balanceAmount = balanceAmount;
    }

    public double getBalanceAmount(){
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount){
        this.balanceAmount = balanceAmount;
    }
}
