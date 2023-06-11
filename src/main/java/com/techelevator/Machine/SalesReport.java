package com.techelevator.Machine;

import com.techelevator.CustomerInfo.Customer;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class SalesReport {
    //int private final totalSales;
    VendingMachine vendingMachine = new VendingMachine();

    public void onSelection() {

        System.out.println("Current Money Provided : $");
        File salesOutput = new File(vendingMachine.getDateFormatted() + vendingMachine.getTimeFormatted() + "Sales");

        try (PrintWriter salesPrint = new PrintWriter(salesOutput)) {


        } catch (Exception ex) {
            System.out.println("Something went wrong");

        }
    }

}
