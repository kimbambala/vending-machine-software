package com.techelevator.Machine;

import com.techelevator.CustomerInfo.Customer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;

public class VendingMachine {

    private Map<String, Item> itemLocation = new HashMap<>();
    private double machineMoney;
    private final double NICKEL = 0.05;
    private final double DIME = 0.10;
    private final double QUARTER = 0.25;




    public double calculateChange(Customer customer){
        machineMoney = customer.getFeedAmount();
        int quarterCount = 0;
        int dimeCounter = 0;
        int nickelCounter = 0;
        while ( machineMoney  >= QUARTER){
           machineMoney  = machineMoney - QUARTER;
            quarterCount++;
        }
        while(machineMoney >= DIME){
            machineMoney = machineMoney - DIME;
            dimeCounter++;
        }
        while(machineMoney >= NICKEL){
            machineMoney = machineMoney - NICKEL;
            nickelCounter++;
        }
        if(quarterCount + dimeCounter + nickelCounter == 0){
            System.out.println("You have no change");
        }
        else {
            System.out.println("Your change is: " + quarterCount + " quarter(s), " + dimeCounter + " dime(s), " + nickelCounter + " nickel(s).");
        }
        customer.setBalanceAmount(customer.getBalanceAmount() + customer.getFeedAmount());
        customer.setFeedAmount(machineMoney);
        return customer.getFeedAmount();

    }


    public void readFile(Customer customer) {
        File itemList = new File("vendingmachine.csv");
        try (Scanner scanner = new Scanner(itemList);) {

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\\|");

                double amount = Double.parseDouble(line[2]);
                Item item = null;
                int quantity = 5;
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
            if(value.getQuantity() > 0) {
                System.out.println(value.getName() + "| Quantity: " + value.getQuantity());
            } else{
                System.out.println(value.getName() + "| SOLD OUT");
            }
        }
    }

    public void itemSelection(Customer customer) {


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
            purchase.onSelection(customer, this);
        }

        if(itemLocation.get(choice).getQuantity() == 0){
            System.out.println("Sorry! Sold out!");
        } else if(customer.getFeedAmount() < itemLocation.get(choice).getPrice()){
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
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            System.out.println("Previous balance: " + numberFormat.format(customer.getFeedAmount()));
            double currentBalance = customer.getFeedAmount();
            double newBalance = currentBalance - itemLocation.get(choice).getPrice();
            customer.setFeedAmount(newBalance);
            System.out.println("New balance: " + numberFormat.format(customer.getFeedAmount()));

            System.out.println(itemLocation.get(choice).getQuantity());

            int updatedQuantity = itemLocation.get(choice).getQuantity() - 1;
            itemLocation.get(choice).setQuantity(updatedQuantity);
            System.out.println(itemLocation.get(choice).getQuantity());



            DecimalFormat dateFormat = new DecimalFormat("#00");
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            int year = date.getYear();
            int month = Integer.parseInt(dateFormat.format (date.getMonthValue()));
            int day = Integer.parseInt(dateFormat.format(date.getDayOfMonth()));


            int hour = time.getHour();
            int minute = time.getMinute();
            int second = time.getSecond();
           // String sec = time.format();

            String printDate = month + "/" + day + "/" + year + " " + hour +":" + minute + ":" + second;
            String printName = itemLocation.get(choice).getName() +" " + choice;
            double printAmountSpent = Double.parseDouble(numberFormat.format(itemLocation.get(choice).getPrice()));
            double printRemainingBalance = Double.parseDouble(numberFormat.format(customer.getFeedAmount()));


            File transactionLog = new File("Log.txt");

            try(PrintWriter transactionOutput = new PrintWriter(new FileOutputStream(transactionLog, true)) ) {
                transactionOutput.println(printDate + " " + printName + " $" +  printAmountSpent + " $" + printRemainingBalance);
            }
            catch (Exception exception){
                System.out.println("Cannot open file for writing");
            }


        }




    }
    /*public void transactionLog(){
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        File transactionLog = new File("Log.txt");

        try(PrintWriter transactionOutput = new PrintWriter(new FileOutputStream(transactionLog, true)) ) {
            transactionOutput.print(date + " " + time + " " + itemLocation.get(choice));
        }
        catch (Exception exception){
            System.out.println("Cannot open file for writing");
        }



    }*/


}
