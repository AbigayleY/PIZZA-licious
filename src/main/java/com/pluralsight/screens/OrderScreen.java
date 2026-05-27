package com.pluralsight.screens;

import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.PizzaSize;
import com.pluralsight.enums.DrinkSize;
import com.pluralsight.models.*;

import java.util.Scanner;

public class OrderScreen {
    static Scanner scanner = new Scanner(System.in);

    private Order order;

    OrderScreen() {
        order = new Order();
    }

    public void display() {
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n -----------------------------");
            System.out.println();
            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Garlic Knots");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addPizza();
                    break;

                case "2":
                    addDrink();
                    break;

                case "3":
                    order.addItem(new GarlicKnots());
                    break;

                case "4":
                    CheckoutScreen checkoutScreen = new CheckoutScreen(order);

                    checkoutScreen.display();
                    ordering = false;
                    break;

                case "0":
                    System.out.println("Your order has been canceled.");
                    ordering = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


private void addPizza(){
        Pizza pizza= new Pizza(PizzaSize.MEDIUM,CrustType.REGULAR);

        pizza.addMeat("Pepperoni");
        pizza.addCheese("Mozzarella");

        order.addItem(pizza);
    System.out.println("Pizza added!🍕");}

private void addDrink(){
        Drink drink = new Drink(DrinkSize.MEDIUM, "Coke");
        order.addItem(drink);
    System.out.println("Drink added! 🥤");}
}