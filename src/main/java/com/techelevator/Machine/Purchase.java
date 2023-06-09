package com.techelevator.Machine;

import com.techelevator.CustomerInfo.Customer;
import com.techelevator.view.Menu;

import java.io.InputStream;
import java.io.OutputStream;


public class Purchase {
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    //private int currentMoney;
    private static Item item = new Item();

    private static VendingMachine vendingMachine = new VendingMachine();
    private static Customer customer = new Customer(20, 0);


    public void onSelection(Customer customer){
       System.out.println("Current Money Provided: " + customer.getFeedAmount());
        while(true) {

            String choice = (String) Menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
            if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                customer.feedMoney(customer.getBalanceAmount(), customer.getFeedAmount());
            } else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                vendingMachine.itemSelection(customer);
            } else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                vendingMachine.calculateChange(customer);

                break;

            }
        }


    }




}
