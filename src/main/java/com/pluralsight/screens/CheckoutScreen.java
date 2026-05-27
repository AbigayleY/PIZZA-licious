package com.pluralsight.screens;

import com.pluralsight.models.Order;
import com.pluralsight.service.ReceiptWriter;

import java.util.Scanner;

public class CheckoutScreen {
    private Order order;

    Scanner scanner = new Scanner(System.in);

    public CheckoutScreen(Order order){
        this.order = order;
    }

    public void display(){
        System.out.println("\n ====| CHECKOUT |==== ");
        System.out.println(order.getReceiptText());
        System.out.println();
        System.out.println("1) Confirm");
        System.out.println("0) Cancel");
        String choice=scanner.nextLine();

        switch(choice){
            case "1":
                ReceiptWriter receiptWriter = new ReceiptWriter();
                receiptWriter.saveReceipt(order.getReceiptText());

                System.out.println("Receipt has been saved! 📜");
                break;

            case "0":
                System.out.println("Your order has been canceled.");
                break;
        }
    }

}
