package com.pluralsight.models;

import com.pluralsight.interfaces.OrderItem;

public class GarlicKnots implements OrderItem{

    @Override
    public double getPrice(){
        return 1.50;}

    @Override
    public String getReceiptText() {
        return "Garlic Knots = $1.50";

    }
}
