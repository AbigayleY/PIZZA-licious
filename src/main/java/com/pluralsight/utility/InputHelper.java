package com.pluralsight.utility;

import java.util.Scanner;

public class InputHelper {

    public static int getIntInput(
            Scanner scanner,
            int min,
            int max){

        while(true){
            try{
                int input = Integer.parseInt(scanner.nextLine());

              if (input < min || input > max){
                  System.out.println("Select an option between "
                  + min + " and " + max);
                  continue;
              }
                return input;
            }
            catch (NumberFormatException e){
                System.out.println("Invalid number! Please try again. ❌");}
        }
    }

    public static boolean getYesNoInput(Scanner scanner){
        while(true){
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("y")){
                return true;
            }

            if (input.equalsIgnoreCase("n")){
                return false;
            }
            System.out.println("Please enter: (y/n) ");}
    }

    public static String getRequiredString(Scanner scanner){
        while(true){
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()){
                return input;
            }
            System.out.println("Input cannot be empty. Please try again. ❌");}
    }
}
