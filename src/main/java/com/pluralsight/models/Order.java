package com.pluralsight.models;

import com.pluralsight.interfaces.OrderItem;
import java.util.ArrayList;

public class Order {
    private ArrayList<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }


    public void addItem(OrderItem item) {
        items.add(item);}
    public ArrayList<OrderItem> getItems() {
        return items;}


    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice();}
        return total;
    }

    public String getReceiptText() {
        StringBuilder receipt = new StringBuilder();
        for (OrderItem item : items) {
        receipt.append(item.getReceiptText()).append("\n");
    }
    receipt.append("\n Total: $")
            .append(String.format("%.2f", calculateTotal()));

        return receipt.toString();}
}