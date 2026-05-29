package com.pluralsight.screens;

import com.pluralsight.utility.InputHelper;
import java.io.File;
import java.util.Scanner;

public class HomeScreen {
    private Scanner scanner = new Scanner(System.in);

    public  void display(){

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\u001B[33m\nWelcome to PIZZA-Licious 🍕\u001B[0m");
            System.out.println();
            System.out.println(" \u001B[35m===== | HOME SCREEN | ====\u001B[0m ");
            System.out.println();
            System.out.println("1) Place an Order");
            System.out.println("0) Exit");

            //error handling with choice
            int choice = InputHelper.getIntInput(scanner,0,1);

            switch (choice) { // lets me change my case to int instead of String
                case 1:
                    OrderScreen orderScreen = new OrderScreen();
                    orderScreen.display();
                    break;

                case 0:
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.❌");
            }
        }
    }

    private void showReceipts(){
        File folder = new File("receipts");
        File[] receipts = folder.listFiles();

        if (receipts == null || receipts.length == 0){
            System.out.println("No receipts found. ❌");
            return;
        }
        for (File receipt : receipts){
            System.out.println(receipt.getName());
        }
    }

}