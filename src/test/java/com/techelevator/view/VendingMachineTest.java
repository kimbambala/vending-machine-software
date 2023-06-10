package com.techelevator.view;

import com.techelevator.CustomerInfo.Customer;
import com.techelevator.Machine.VendingMachine;
import org.junit.Assert;
import org.junit.Test;

public class VendingMachineTest {

    @Test
    public void test_calculateChange_so_machine_has_zero_money_left_from_customer(){
        //Arrange
        VendingMachine vendingMachine = new VendingMachine();

        //Act
        double result = vendingMachine.calculateChange(new Customer (5.00, 6.30));
        boolean isTrue = false;
        if(result == 0.0){
            isTrue = true;
        }
        //Assert

        Assert.assertEquals(isTrue, true);
    }

    @Test
    public void test_calculateChange_so_machine_returns_correct_change(){
        //Arrange
        VendingMachine vendingMachine = new VendingMachine();

        //Act
        vendingMachine.calculateChange(new Customer (5.00, 6.30));
        int resultQuarter = vendingMachine.getQuarterCount();
        int resultDime = vendingMachine.getDimeCounter();
        int resultNickel = vendingMachine.getNickelCounter();


        //Assert
        Assert.assertEquals(25, resultQuarter);
        Assert.assertEquals(0, resultDime);
        Assert.assertEquals(1, resultNickel);

    }

    @Test
    public void test_readFile_(){

    }
}


