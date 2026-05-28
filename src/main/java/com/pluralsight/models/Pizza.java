package com.pluralsight.models;

import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.PizzaSize;
import com.pluralsight.enums.RegularTopping;
import com.pluralsight.enums.*;
import com.pluralsight.interfaces.OrderItem;

import java.util.ArrayList;


public class Pizza implements OrderItem {
    private PizzaSize size;
    private CrustType crustType;

    private ArrayList<PizzaTopping<Meat>> meats;
    private ArrayList<PizzaTopping<Cheese>> cheeses;
    private ArrayList<RegularTopping> toppings;
    private ArrayList<Sauce> sauces;

    private boolean stuffedCrust;


    public Pizza(PizzaSize size, CrustType crustType) {
        this.size = size;
        this.crustType = crustType;

        meats = new ArrayList<>();
        cheeses = new ArrayList<>();
        toppings = new ArrayList<RegularTopping>();
        sauces = new ArrayList<>();
    }


    public void addMeat(PizzaTopping<Meat> meat) {
        meats.add(meat);
    }

    public void addCheese(PizzaTopping<Cheese> cheese) {
        cheeses.add(cheese);
    }

    public void addTopping(RegularTopping topping) {
        toppings.add(topping);
    }

    public void addSauce(Sauce sauce) {
        sauces.add(sauce);
    }

    public void setStuffedCrust(boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
    }


    @Override
    public double getPrice() {
        double total = getBasePrice();

        for (PizzaTopping<Meat> meat : meats) {
            total += getMeatPrice();

            if (meat.isExtra()) {
                total += getExtraMeatPrice();
            }
        }

        for (PizzaTopping<Cheese> cheese : cheeses) {
            total += getCheesePrice();

            if (cheese.isExtra()) {
                total += getExtraCheesePrice();
            }
        }
        if (stuffedCrust){
            total += 2;
    }
        return total;
}


    public double getBasePrice() {

        switch (size){
            case SMALL:
                return 8.50;

            case MEDIUM:
                return  12.00;

            case LARGE:
                return  16.50;

        default:
            return 0;}
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

    private double getExtraMeatPrice(){
        switch (size){
            case SMALL:
                return .50;

            case MEDIUM:
                return 1.00;

            case LARGE:
                return 1.50;

            default:
                return 0;
        }
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

    private double getExtraCheesePrice(){
        switch (size){
            case SMALL:
                return .30;

            case MEDIUM:
                return .60;

            case LARGE:
                return .90;

            default:
                return 0;
        }
    }


    @Override
    public String getReceiptText() {

        StringBuilder text = new StringBuilder();

        text.append(size)
                .append(" ")
                .append(crustType)
                .append(" Pizza\n");

        text.append("Meats:\n");
        for (PizzaTopping<Meat> meat : meats){
            text.append("- ")
                    .append(meat.getTopping());

            if (meat.isExtra()){
                text.append(" (EXTRA) ");
            }
            text.append("\n");
        }

        text.append("Cheeses:\n");
        for (PizzaTopping<Cheese> cheese : cheeses){
            text.append("- ")
                    .append(cheese.getTopping());
            if (cheese.isExtra()){
                text.append(" (EXTRA) ");
            }
            text.append("\n");
        }

        text.append("Toppings:\n");
        for (RegularTopping topping : toppings){
            text.append("- ")
                    .append(topping)
                    .append("\n");
        }

        text.append("Sauces:\n");
        for (Sauce sauce: sauces){
            text.append("- ")
                    .append(sauce)
                    .append("\n");
        }
        if (stuffedCrust){
            text.append("Stuffed Crust\n");
        }

        text.append("Price: $")
                .append(String.format("%.2f", getPrice()))
                .append("\n");

        return  text.toString();
    }
}
