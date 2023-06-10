package com.techelevator.CustomerInfo;

import com.techelevator.Transactionable;

import java.text.DecimalFormat;

public class Customer {
    private double balanceAmount = 20;
    private double feedAmount;

    public Customer(double balanceAmount, double feedAmount){
        this.balanceAmount = balanceAmount;
        this.feedAmount = feedAmount;
    }

    public double getBalanceAmount(){
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount){
        this.balanceAmount = balanceAmount;
    }

    public double getFeedAmount(){
        return feedAmount;
    }

    public void setFeedAmount(double feedAmount){
        this.feedAmount = feedAmount;
    }

    public void feedMoney(double balanceAmount, double feedAmount){
        if(balanceAmount > 0){

            double updatedBalance = balanceAmount - 1;
            setBalanceAmount(updatedBalance);
            DecimalFormat numberFormat  = new DecimalFormat("#.00");
            System.out.println("Money left in Wallet: " + numberFormat.format(getBalanceAmount()));

            double updatedFeedAmount = feedAmount + 1;
            setFeedAmount(updatedFeedAmount);
            System.out.println("Current money provided: " + numberFormat.format(getFeedAmount()));
        }else{
            System.out.println("You are out of money!");
        }
    }
}
