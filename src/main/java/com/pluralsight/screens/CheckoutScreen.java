package com.pluralsight.screens;

import com.pluralsight.models.Order;
import com.pluralsight.service.ReceiptWriter;
import com.pluralsight.utility.InputHelper;

import java.util.Scanner;

public class CheckoutScreen {
    private Order order;

    private Scanner scanner = new Scanner(System.in);

    //constructor
    public CheckoutScreen(Order order){
        this.order = order;
    }

    public void display(){
        System.out.println("\n ====| CHECKOUT |==== ");
        System.out.println(order.getReceiptText());
        System.out.println();
        System.out.println("Would you like to confirm your order? (y/n)");

        boolean confirm = InputHelper.getYesNoInput(scanner);

        if (confirm) {
            ReceiptWriter receiptWriter = new ReceiptWriter();
            receiptWriter.saveReceipt(order.getReceiptText());

            System.out.println("Thank you, Order confirmed! ✅");
            System.out.println("Receipt has been saved! 📜");

        } else {
            System.out.println("Your order has been canceled.");
        }
    }
}
