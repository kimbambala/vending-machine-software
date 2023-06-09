package com.techelevator.Machine;

import com.techelevator.CustomerInfo.Customer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    private Map<String, Item> itemLocation = new HashMap<>();
    private double machineMoney;
    private final double NICKEL = 5;
    private final double DIME = 10;
    private final double QUARTER = 25;

    public double smallestChange(){

    }






    public void readFile(Customer customer) {
        File itemList = new File("vendingmachine.csv");
        try (Scanner scanner = new Scanner(itemList);) {

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\\|");



                double amount = Double.parseDouble(line[2]);
                int quantity = 5;
                Item item = null;
                if (line[3].equalsIgnoreCase("Chip")) {
                    item = new Chip(line[1], amount, quantity);
                } else if (line[3].equalsIgnoreCase("Candy")) {
                    item = new Candy(line[1], amount, quantity);
                } else if (line[3].equalsIgnoreCase("Drink")) {
                    item = new Drink(line[1], amount, quantity);
                } else if (line[3].equalsIgnoreCase("Gum")) {
                    item = new Gum(line[1], amount, quantity);

                }
                itemLocation.put(line[0], item);
            }

        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }

    }

    public void itemDisplay(Customer customer) {
        for(Map.Entry<String, Item> entry : itemLocation.entrySet()){
            String key = entry.getKey();
            Item value = entry.getValue();
            System.out.println(value.getName() + "|" + value.getQuantity());
        }
    }

    public void itemSelection(Customer customer) {
        readFile(customer);
        for(Map.Entry<String, Item> entry : itemLocation.entrySet()){
            String key = entry.getKey();
            Item value = entry.getValue();
            System.out.println(key + "|" + value.getName());
        }

        System.out.println("Please select an item");
        Scanner itemChoice = new Scanner(System.in);
        String choice = itemChoice.nextLine().toUpperCase();

        if(!itemLocation.containsKey(choice)){
            System.out.println("Invalid selection");
            Purchase purchase = new Purchase();
            purchase.onSelection(customer);
        }

        if(customer.getFeedAmount() < itemLocation.get(choice).getPrice()){
            System.out.println("Sorry! Not enough funds.");
        }else {
            System.out.println("You have selected " + itemLocation.get(choice).getName());
            if(itemLocation.get(choice) instanceof Chip){
                System.out.println("Crunch Crunch, Yum!");
            }else if(itemLocation.get(choice) instanceof Candy){
                System.out.println("Munch Munch, Yum!");
            }else if(itemLocation.get(choice) instanceof Drink){
                System.out.println("Glug Glug, Yum!");
            }else{
                System.out.println("Chew Chew, Yum!");
            }
            System.out.println("Previous balance: " + customer.getFeedAmount());
            double currentBalance = customer.getFeedAmount();
            double newBalance = currentBalance - itemLocation.get(choice).getPrice();
            customer.setFeedAmount(newBalance);
            System.out.println("New balance: " + customer.getFeedAmount());
            int updatedQuantity = itemLocation.get(choice).getQuantity() - 1;
            itemLocation.get(choice).setQuantity(updatedQuantity);
        }


    }
}
