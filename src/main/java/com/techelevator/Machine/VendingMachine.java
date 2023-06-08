package com.techelevator.Machine;

import com.techelevator.CustomerInfo.Customer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    private Map<String, Item> itemLocation = new HashMap<>();

    public void readFile(Customer customer) {
        File itemList = new File("vendingmachine.csv");
        try (Scanner scanner = new Scanner(itemList);) {

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\\|");

                System.out.println(line[0] + "|" + line[1] + "|" + line[2] + "| Quantity: 5");

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
        readFile(customer);
    }

    public void itemSelection(Customer customer) {
        readFile(customer);
        for(Item value : itemLocation.values()){
            System.out.println(value.toString());
        }




        System.out.println("Please select an item");
        Scanner itemChoice = new Scanner(System.in);
        String choice = itemChoice.nextLine();

        if(customer.getFeedAmount() < itemLocation.get(choice).getPrice()){
            System.out.println("Sorry! Not enough funds.");
        }else {

            System.out.println("Dispensing " + itemLocation.get(choice).getName());
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