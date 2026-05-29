package com.pluralsight.screens;

import com.pluralsight.enums.*;
import com.pluralsight.models.*;
import com.pluralsight.interfaces.OrderItem;
import com.pluralsight.utility.InputHelper;

import java.util.Scanner;

public class AddItemScreen {
    private Scanner scanner;

    //constructor
    public AddItemScreen(Scanner scanner) {
        this.scanner = scanner;}


    public OrderItem createItem() {
        System.out.println("\n ==== | ADD ITEM | ==== ");
        System.out.println();
        System.out.println("1) Pizza");
        System.out.println("2) Drink");
        System.out.println("3) Garlic Knots");

        //error handling with choice
        int choice = InputHelper.getIntInput(scanner,1,3);

        switch (choice) {
            case 1:
                return createPizza();

            case 2:
                return createDrink();

            case 3:
                return new GarlicKnots();

            default:
                return null;
        }
    }


    private Pizza createPizza() {
        PizzaSize[] sizes = PizzaSize.values();
        System.out.println("\n Choose Pizza Size:");

        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ") " + sizes[i]);
        }

        //error handling
        int sizeChoice = InputHelper.getIntInput(scanner,1,sizes.length);

        PizzaSize size = sizes[sizeChoice - 1];

    //CRUSTS--------------------------------------------------
        CrustType[] crusts = CrustType.values();
        System.out.println("\n Choose Crust:");

        for (int i = 0; i < crusts.length; i++) {
            System.out.println((i + 1) + ") " + crusts[i]);
        }
        int crustChoice = InputHelper.getIntInput(scanner,1,crusts.length);
        CrustType crust = crusts[crustChoice -1];
        Pizza pizza = new Pizza(size,crust);

    //MEATS----------------------------------------------------
        System.out.println("==== | MEATS | ==== ");
        for(Meat meat : Meat.values()) {
            System.out.println("Add " + meat + "? (y/n)");

            //error handling y/n
            boolean add = InputHelper.getYesNoInput(scanner);

            if (add){
                System.out.println("Extra " + meat + "? (y/n)");

                boolean extra = InputHelper.getYesNoInput(scanner);

                pizza.addMeat(new PizzaTopping<>(meat, extra));}
        }

    //CHEESES-----------------------------------------------------
        System.out.println("==== | CHEESES | ==== ");
        for(Cheese cheese : Cheese.values()) {
            System.out.println("Add " + cheese + "? (y/n)");

            //error handling y/n
            boolean add = InputHelper.getYesNoInput(scanner);

            if (add){
                System.out.println("Extra " + cheese + "? (y/n)");

                boolean extra = InputHelper.getYesNoInput(scanner);

                pizza.addCheese(new PizzaTopping<>(cheese, extra));}
        }


    //TOPPINGS-----------------------------------------------------------
        System.out.println("=== TOPPINGS ===");
        for(RegularTopping topping : RegularTopping.values()) {
            System.out.println("Add " + topping + "? (y/n)");

            boolean add = InputHelper.getYesNoInput(scanner);

            if (add){
                pizza.addTopping(topping);}
        }


    //SAUCES----------------------------------------------------------
        System.out.println("=== SAUCES ===");
        for(Sauce sauce : Sauce.values()) {
            System.out.println("Add " + sauce + "? (y/n)");

            boolean add = InputHelper.getYesNoInput(scanner);

            if (add){pizza.addSauce(sauce);}
    }

    //STUFFED CRUST-----------------------------------------------
        System.out.println("\nStuffed crust? (y/n)");

        boolean stuffed = InputHelper.getYesNoInput(scanner);

        pizza.setStuffedCrust(stuffed);
        return pizza;
    }

    private Drink createDrink() {
        System.out.println("Choose Drink Size:");
        DrinkSize[] sizes = DrinkSize.values();
        for(int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ") " + sizes[i]);
        }

        int choice = InputHelper.getIntInput(scanner,1,sizes.length);
        DrinkSize size = sizes[choice - 1];

        System.out.println("Enter Flavor:");
        String flavor = InputHelper.getRequiredString(scanner);

        return new Drink(size, flavor);
    }
}
