package com.techelevator.Machine;

import com.techelevator.CustomerInfo.Customer;
import com.techelevator.view.Menu;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Item {

    private static final String SLOT_IDENTIFIER = "A1";
    private static final String PRODUCT_NAME = "Potato Crisp";
    private static final String PRODUCT_PRICE = "3.05";
    private static final String[] ITEM_MENU_OPTIONS = { SLOT_IDENTIFIER, PRODUCT_NAME, PRODUCT_PRICE};

    private String name;
    private double price;
    private int quantity;
    private Map<String, Item> itemLocation = new HashMap<>();

    public Item(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public Item(){

    }

    public String getType(){
        return name;
    }

    public void setType(String type){
        this.name = type;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void readFile(Customer customer){
        File itemList = new File("vendingmachine.csv");
        try(Scanner scanner = new Scanner(itemList);){

            while(scanner.hasNextLine()){
                String [] line = scanner.nextLine().split("\\|");

                System.out.println(line[0] + "|" + line[1] + "|" + line[2] + "| Quantity: " + getQuantity());

            }

        }catch (Exception ex){
            System.out.println("Something went wrong");
        }

    }

    public  void itemDisplay(Customer customer){
        readFile(customer);
        /*System.out.println("Select an Item");

        File itemList = new File("vendingmachine.csv");

        Chip potatoCrisps = new Chip("potato crisps", 3.05, quantity);
        itemLocation.put("A1", potatoCrisps);

        Scanner itemChoice = new Scanner(System.in);
        String choice = itemChoice.nextLine();

        System.out.println(itemLocation.get(choice).price);



        try(Scanner scanner = new Scanner(itemList);){

            while(scanner.hasNextLine()){
                String [] line = scanner.nextLine().split("\\|");
                double amount = Integer.parseInt(line[2]);
                if(line[1].equalsIgnoreCase("Potato Crisps")){
                    Chip potatoCrisps = new Chip(line[1], amount, quantity);
                } else if(line[1].equalsIgnoreCase("Stackers")){
                    Chip stackers = new Chip(line[1], amount, quantity);
                } else if(line[1].equalsIgnoreCase("Grain Waves")){
                    Chip grainWaves = new Chip(line[1], amount, quantity);
                } else if(line[1].equalsIgnoreCase("Cloud Popcorn")){
                    Chip cloudPopcorn = new Chip(line[1], amount, quantity);

                } else if(line[1].equalsIgnoreCase("Moonpie")){
                    Candy moonpie = new Candy(line[1], amount, quantity);
                } else if(line[1].equalsIgnoreCase("Cowtales")){
                    Candy cowtales = new Candy(line[1], amount, quantity);
                } else if(line[1].equalsIgnoreCase("Wonka Bar")){
                    Candy wonkaBar = new Candy(line[1], amount, quantity);
                } else if(line[1].equalsIgnoreCase("Crunchie")){
                    Candy crunchie = new Candy(line[1], amount, quantity);
                }

                else if(line[1].equalsIgnoreCase("Cola")){
                    Drink cola = new Drink(line[1], amount, quantity);
                } else if(line[1].equalsIgnoreCase("Dr. Salt")){
                    Drink drSalt = new Drink(line[1], amount, quantity);
                } else if(line[1].equalsIgnoreCase("Mountain Melter")){
                    Drink mountainMelter = new Drink(line[1], amount, quantity);
                } else if(line[1].equalsIgnoreCase("Heavy")){
                    Drink heavy = new Drink(line[1], amount, quantity);
                }

                else if(line[1].equalsIgnoreCase("U-Chews")){
                    Gum uChews = new Gum(line[1], amount, quantity);
                }else if(line[1].equalsIgnoreCase("Little League Chew")){
                    Gum littleLeagueChew = new Gum(line[1], amount, quantity);
                }else if(line[1].equalsIgnoreCase("Chiclets")){
                    Gum chiclets = new Gum(line[1], amount, quantity);
                }else if(line[1].equalsIgnoreCase("Triplemint")){
                    Gum triplemint = new Gum(line[1], amount, quantity);
                }
                itemLocation.put(line[0], );
                System.out.println(line[0] + "|" + line[1] + "|" + line[2] + "| Quantity: " + getQuantity());

            }

            }catch (Exception ex){
            System.out.println("Something went wrong");
        }
                /*String [] itemArray = scanner.nextLine().split("\\|");

                double itemArray3 = Integer.parseInt(itemArray[2]);
                String itemName = itemArray[1];
                String itemReference = itemArray[0];*/
               /* if(itemArray[3].equalsIgnoreCase("Chip")) {
                    int itemCounter =0;
                    if(itemCounter == 0) {
                        Chip potatoCrisps = new Chip(itemArray[1], itemArray3);
                        itemCounter++;
                    }if(itemCounter == 1){
                        Chip stackers = new Chip(itemArray[1], itemArray3);
                        itemCounter++;
                    }

                    itemLocation.put(itemReference, chip);
                }else if(itemArray[3].equalsIgnoreCase("Candy")){

                    Candy candy = new Candy(itemArray[1], itemArray3);
                    itemLocation.put(itemReference, candy);
                }else if(itemArray[3].equalsIgnoreCase("Drink")){

                    Drink drink = new Drink(itemArray[1], itemArray3);
                    itemLocation.put(itemReference, drink);
                }else {
                    Gum gum = new Gum(itemArray[1], itemArray3);
                    itemLocation.put(itemReference, gum);
                }
            }

            for(Map.Entry<String, Item> entry : itemLocation.entrySet()){
                String key = entry.getKey();
                Item value = entry.getValue();
                System.out.println(key + "|" + value.name + "| Quantity: 5" );
            }


        }catch (Exception ex){
            System.out.println("Something's gone wrong.");
        }*/
    }

    public void itemSelection(Customer customer){
        readFile(customer);

        Chip potatoCrisps = new Chip("potato crisps", 3.05, quantity);
        itemLocation.put("A1", potatoCrisps);

        System.out.println("Please select an item");
        Scanner itemChoice = new Scanner(System.in);
        String choice = itemChoice.nextLine();

        System.out.println("Dispensing " + itemLocation.get(choice).name);
        System.out.println("Previous balance: " + customer.getBalanceAmount());
        double currentBalance = customer.getBalanceAmount();
        double newBalance = currentBalance - itemLocation.get(choice).price;
        customer.setBalanceAmount(newBalance);
        System.out.println("New balance: " + customer.getBalanceAmount());
        int updatedQuantity = itemLocation.get(choice).getQuantity() - 1;
        itemLocation.get(choice).setQuantity(updatedQuantity);
        /*System.out.println("Current Money Provided: ");
        while(true) {

            String choice = (String) Menu.getChoiceFromOptions(ITEM_MENU_OPTIONS);
            if (choice.equals(SLOT_IDENTIFIER)) {
                //item.onSelection(customer);
            } else if (choice.equals(PRODUCT_NAME)) {
                // purchase.onSelection(customer);
            }else if (choice.equals(PRODUCT_PRICE)) {

            } else if (choice.equals(PRODUCT_PRICE)) {
                break;

            }
        }

*/
    }

}
