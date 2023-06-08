package com.techelevator.Machine;

import com.techelevator.CustomerInfo.Customer;

public class Item {

    private String type;
    private double price;

    public Item(String type, double price){
        this.type = type;
        this.price = price;

    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public  void onSelection(Customer customer){
        System.out.println("Select an Item");
    }

}
