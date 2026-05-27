package com.pluralsight.models;

import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.PizzaSize;
import com.pluralsight.interfaces.OrderItem;

import java.util.ArrayList;


public class Pizza implements OrderItem {
    private PizzaSize size;
    private CrustType crustType;

    private ArrayList<String> meats;
    private ArrayList<String> cheeses;
    private ArrayList<String> toppings;
    private ArrayList<String> sauces;

    private boolean stuffedCrust;



    public Pizza(PizzaSize size, CrustType crustType){
        this.size = size;
        this.crustType = crustType;

        meats = new ArrayList<>();
        cheeses = new ArrayList<>();
        toppings = new ArrayList<>();
        sauces = new ArrayList<>();
    }



    public  void addMeat(String meat){
        meats.add(meat);}
    public void addCheese(String cheese){
        cheeses.add(cheese);}
    public void addTopping(String topping){
        toppings.add(topping);}
    public void addSauce(String sauce){
        sauces.add(sauce);}

    public void setStuffedCrust(boolean stuffedCrust){
        this.stuffedCrust = stuffedCrust;}



    @Override
    public double getPrice() {
        double price = 0;
        switch (size){

            case SMALL:
                price = 8.50;
                break;

            case MEDIUM:
                price = 12.00;
                break;

            case LARGE:
                price = 16.50;
                break;}

        price += meats.size()* getMeatPrice();
        price += cheeses.size()* getCheesePrice();

        if ((stuffedCrust)){
            price += 2;}

        return price;
    }

    private double getMeatPrice(){
        switch (size){
            case SMALL:
                return 1.00;

            case MEDIUM:
                return 2.00;

            case LARGE:
                return 3.00;

            default:
                return 0;}
    }
    private double getCheesePrice(){
        switch (size){
            case SMALL:
                return .75;

            case MEDIUM:
                return 1.50;

            case LARGE:
                return 2.25;

            default:
                return 0;
        }
    }


    @Override
    public String getReceiptText() {
        return size + " pizza - $" + getPrice();
    }
}
