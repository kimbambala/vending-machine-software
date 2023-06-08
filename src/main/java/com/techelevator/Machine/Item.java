package com.techelevator.Machine;

import com.techelevator.CustomerInfo.Customer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Item {

    private String type;
    private double price;
    private Map<String, String> itemLocation = new HashMap<>();

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

        File itemList = new File("vendingmachine.csv");


        try(Scanner scanner = new Scanner(itemList);){

            while(scanner.hasNextLine()){
                String [] itemArray = scanner.nextLine().split("\\|");
                itemLocation.put(itemArray[0], itemArray[1]);
                double itemArray3 = Integer.parseInt(itemArray[3]);
                System.out.println(itemArray[0] + " " + itemArray[1]);

                //Item item  = new Item(itemArray[2], itemArray3);
            }



        }catch (Exception ex){
            System.out.println("Something's gone wrong.");
        }
    }

}
