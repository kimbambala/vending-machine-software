package com.techelevator.CustomerInfo;

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
        if(balanceAmount >= 0){

            double updatedBalance = balanceAmount - 1;
            setBalanceAmount(updatedBalance);
            System.out.println("Money left in Wallet: " + balanceAmount);

            double updatedFeedAmount = feedAmount + 1;
            setFeedAmount(updatedFeedAmount);
            System.out.println("Current money provided: " + feedAmount);
        }else{
            System.out.println("You are out of money!");
        }
    }
}
