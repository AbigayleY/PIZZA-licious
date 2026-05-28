package com.pluralsight.screens;

import com.pluralsight.enums.*;
import com.pluralsight.models.*;
import com.pluralsight.interfaces.OrderItem;

import java.util.Scanner;

public class AddItemScreen {
    private Scanner scanner;

    public AddItemScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public OrderItem createItem() {
        System.out.println("\n ==== | ADD ITEM | ==== ");
        System.out.println();
        System.out.println("1) Pizza");
        System.out.println("2) Drink");
        System.out.println("3) Garlic Knots");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                return createPizza();

            case "2":
                return createDrink();

            case "3":
                return new GarlicKnots();

            default:
                return null;
        }
    }

    private Pizza createPizza() {
        PizzaSize size = choosePizzaSize();
        CrustType crustType = chooseCrust();

        Pizza pizza = new Pizza(size, crustType);

        addMeats(pizza);
        addCheeses(pizza);
        addRegularToppings(pizza);
        addSauces(pizza);
        chooseStuffedCrust(pizza);

        return pizza;
    }

    private PizzaSize choosePizzaSize() {
        System.out.println("\n Choose Pizza Size:");
        PizzaSize[] sizes = PizzaSize.values();

        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ") " + sizes[i]);
        }
        int choice = Integer.parseInt((scanner.nextLine()));
        return sizes[choice - 1];
    }

    private CrustType chooseCrust() {
        System.out.println("\n Choose Crust:");
        CrustType[] crusts = CrustType.values();

        for (int i = 0; i < crusts.length; i++) {
            System.out.println((i + 1) + ") " + crusts[i]);
        }
        int choice = Integer.parseInt(scanner.nextLine());
        return crusts[choice - 1];
    }

    private void addMeats(Pizza pizza) {
        System.out.println("==== | MEATS | ==== ");
        for(Meat meat : Meat.values()) {
            System.out.println("Add " + meat + "? (y/n)");

            if(scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.println("Extra " + meat + "? (y/n)");

                boolean extra =
                        scanner.nextLine()
                                .equalsIgnoreCase("y");

                pizza.addMeat(
                        new PizzaTopping<>(meat, extra));}
        }
    }

    private void addCheeses(Pizza pizza) {
        System.out.println("==== | CHEESES | ==== ");
        for(Cheese cheese : Cheese.values()) {
            System.out.println("Add " + cheese + "? (y/n)");

            if(scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.println("Extra " + cheese + "? (y/n)");

                boolean extra =
                        scanner.nextLine()
                                .equalsIgnoreCase("y");

                pizza.addCheese(
                        new PizzaTopping<>(cheese, extra));}
        }
    }

    private void addRegularToppings(Pizza pizza) {
        System.out.println("=== TOPPINGS ===");
        for(RegularTopping topping :
                RegularTopping.values()) {
            System.out.println("Add " + topping + "? (y/n)");

            if(scanner.nextLine().equalsIgnoreCase("y")) {
                pizza.addTopping(topping);}
        }
    }

    private void addSauces(Pizza pizza) {
        System.out.println("=== SAUCES ===");
        for(Sauce sauce : Sauce.values()) {
            System.out.println("Add " + sauce + "? (y/n)");

            if(scanner.nextLine().equalsIgnoreCase("y")) {
                pizza.addSauce(sauce);}
        }
    }

    private void chooseStuffedCrust(Pizza pizza) {
        System.out.println("\nStuffed crust? (y/n)");
        pizza.setStuffedCrust(
                scanner.nextLine()
                        .equalsIgnoreCase("y"));
    }

    private Drink createDrink() {
        System.out.println("Choose Drink Size:");
        DrinkSize[] sizes = DrinkSize.values();
        for(int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ") " + sizes[i]);
        }

        int choice = Integer.parseInt(scanner.nextLine());
        DrinkSize size = sizes[choice - 1];

        System.out.println("Enter Flavor:");
        String flavor = scanner.nextLine();

        return new Drink(size, flavor);
    }
}
