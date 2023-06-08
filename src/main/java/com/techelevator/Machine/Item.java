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
    private Map<String, Item> itemLocation = new HashMap<>();

    public Item(String name, double price){
        this.name = name;
        this.price = price;

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

   /* public  void onSelection(Customer customer){
        System.out.println("Select an Item");

        File itemList = new File("vendingmachine.csv");


        try(Scanner scanner = new Scanner(itemList);){

            while(scanner.hasNextLine()){
                String [] itemArray = scanner.nextLine().split("\\|");

                double itemArray3 = Integer.parseInt(itemArray[2]);
                System.out.println(itemArray[0] + " " + itemArray[1]);

                if(itemArray[1].equalsIgnoreCase("potato crisps")){
                    Item potatoCrisps = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("stackers")){
                    Item stackers = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("grain waves")){
                    Item grainWaves = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("cloud popcorn")){
                    Item cloudPopcorn = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("moonpie")){
                    Item moonpie = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("cowtales")){
                    Item cowtales = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("wonka bar")) {
                    Item wonkaBar = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("crunchie")) {
                    Item crunchie = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("cola")) {
                    Item cola = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("dr. salt")) {
                    Item drSalt = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("mountain melter")) {
                    Item mountainMelter = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("heavy")) {
                    Item heavy = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("u-chews")) {
                    Item uChews = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("little league chew")) {
                    Item littleLeageuChew = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("chiclets")) {
                    Item chiclets = new Item(itemArray[3], itemArray3);
                }else if(itemArray[1].equalsIgnoreCase("triplemint")) {
                    Item triplemint = new Item(itemArray[3], itemArray3);
                }else{
                    System.out.println("Item not found");
                }
                for (Item currentItem : itemArray)

                itemLocation.put(itemArray[0], currentItem);
            }



        }catch (Exception ex){
            System.out.println("Something's gone wrong.");
        }
    }*/

    public void onSelection(Customer customer){
        System.out.println("Current Money Provided: ");
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


    }

}
