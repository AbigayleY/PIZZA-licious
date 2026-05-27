package com.pluralsight.models;

import com.pluralsight.enums.DrinkSize;
import com.pluralsight.interfaces.OrderItem;

public class Drink implements OrderItem{
    private DrinkSize size;
    private String flavor;

    //contructor
    public Drink(DrinkSize size, String flavor){
        this.size = size;
        this.flavor = flavor;}


    @Override
    public double getPrice(){
        switch (size){
            case SMALL:
                return 2.00;

            case MEDIUM:
                return 2.50;

            case LARGE:
                return 3.00;

            default:
                return 0;}
    }

    @Override
    public String getReceiptText() {
        return size + " " + flavor + " drink - $" + getPrice();
    }
}
