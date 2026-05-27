package com.pluralsight.screens;

import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.PizzaSize;
import com.pluralsight.enums.DrinkSize;
import com.pluralsight.models.*;

import java.util.Scanner;

public class OrderScreen {
    static Scanner scanner = new Scanner(System.in);

    private Order order;
    OrderScreen(){
        order = new Order();
    }

     public void display(){
        boolean ordering = true;

        while (ordering){
        System.out.println("\n -----------------------------");
        System.out.println();
        System.out.println("1) Add Pizza");
        System.out.println("2) Add Drink");
        System.out.println("3)Add Garlic Knots");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        String choice = scanner.nextLine();

        switch  (choice){
            case "1":

        }

