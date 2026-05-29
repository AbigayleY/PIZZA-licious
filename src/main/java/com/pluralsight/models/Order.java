package com.pluralsight.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.pluralsight.interfaces.OrderItem;
import java.util.ArrayList;

public class Order {
    private ArrayList<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }


    public void addItem(OrderItem item) {
        items.add(item);}

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice();}
        return total;
    }

    public String getReceiptText() {
        StringBuilder receipt = new StringBuilder();

        String currentTime = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a"));

        receipt.append("\n ----- | RECEIPT | -----\n");

        receipt.append("Date: ")
                .append(currentTime)
                .append("\n\n");

        for (OrderItem item : items) {
        receipt.append(item.getReceiptText()).append("\n\n");
    }
    receipt.append("--------------------------");

    receipt.append("\n Grand Total: $")
            .append(String.format("%.2f", calculateTotal()));

        return receipt.toString();}
}