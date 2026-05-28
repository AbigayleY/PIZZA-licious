package com.pluralsight.screens;

import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.PizzaSize;
import com.pluralsight.enums.DrinkSize;
import com.pluralsight.interfaces.OrderItem;
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
            System.out.println("==== | HOME SCREEN | ==== ");
            System.out.println("\n -----------------------------");
            System.out.println();
            System.out.println("1) Add Item");
            System.out.println("2) Checkout");
            System.out.println("0) Cancel Order");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    AddItemScreen addItemScreen =
                            new AddItemScreen(scanner);

                    OrderItem item =
                            addItemScreen.createItem();

                    if(item != null){
                        order.addItem(item);
                        System.out.println("Item added! ➕✅ ");
                    }
                    break;

                case "2":
                    CheckoutScreen checkoutScreen =
                            new CheckoutScreen(order);

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
    System.out.println("\n ==== | PIZZA CREATION | ====");
    System.out.println();

    System.out.println("Choose a Size:");
    System.out.println("1) Small");
    System.out.println("2) Medium");
    System.out.println("3) Large");
    String sizeChoice = scanner.nextLine();

    PizzaSize size;

    switch (sizeChoice){
        case "1":
            size = PizzaSize.SMALL;
            break;

        case "2":
            size = PizzaSize.MEDIUM;
            break;

        case "3":
            size = PizzaSize.LARGE;
            break;

        default:
            size = PizzaSize.MEDIUM;
    }

    System.out.println();
    System.out.println("\n Select a Crust:");
    System.out.println("1) Thin");
    System.out.println("2) Regular");
    System.out.println("3) Thick");
    System.out.println("4) Cauliflower");
    String crustChoice = scanner.nextLine();

    CrustType crustType;

    switch (crustChoice){
        case "1":
            crustType = CrustType.THIN;
            break;

        case "2":
            crustType = CrustType.REGULAR;
            break;

        case "3":
            crustType = CrustType.THICK;
            break;

        case "4":
            crustType = CrustType.CAULIFLOWER;
            break;

        default:
            crustType = CrustType.REGULAR;
    }

    System.out.println("Pizza added!🍕");}

private void addDrink(){
    System.out.println("\n ==== | DRINK SELECTION | ==== ");
    System.out.println();
    System.out.println("Drink Size:");
    System.out.println("1) Small");
    System.out.println("2) Medium");
    System.out.println("3) Large");
    String choice = scanner.nextLine();

    DrinkSize size;

    switch (choice) {
        case "1":
            size = DrinkSize.SMALL;
            break;

        case "2":
            size = DrinkSize.MEDIUM;
            break;

        case "3":
            size = DrinkSize.LARGE;
            break;

        default:
            size = DrinkSize.MEDIUM;
    }

    System.out.println("");

    System.out.println("Drink added! 🥤");}
}