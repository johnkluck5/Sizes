package com.company;
//John Kluck
//CSCI 1010/1011
//Calculates sizes for hat, jacket, and waist

import java.util.*;

public class Sizes {

    //*****************************METHODS***************************
    public static Scanner kbd;

    // Method to get hat size
    public static double hatSize(int weight, int height) {
        return ((double) weight / (double) height) * 2.9;
    }

    //Method to get jacket size
    public static double jacketSize(int weight, int height, int age) {
        double jacket_size = ((double) weight * (double) height) / 288.0;
        double addInches = 0;
        //if over 40, add 1/8 an inch for every 10 years
        if (age >= 40) {
            for (int i = 31; i <= age; i++) {
                if (i % 10 == 0) {
                    addInches += .125;
                }
            }
            jacket_size += addInches;
        }
        return jacket_size;
    }

    // Method to get waist size
    public static double waistSize(int weight, int age) {
        double waist = (double) weight / 5.7;
        //if over 30, add 1/10 for every 2 years
        if (age >= 30) {
            for (int i = 30; i <= age; i++) {
                if (i % 2 == 0) {
                    waist += .1;
                }
            }
        }
        return waist;
    }

    //Method for menu
    public static int menu() {
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("1. Calculate Hat Size\n" +
                    "2. Calculate Jacket Size\n" +
                    "3. Calculate Waist Size\n" +
                    "4. No More Calculations ");
            System.out.print("Enter your choice: ");
            input = kbd.nextInt();
            //check for valid input
            switch (input) {
                case 1:
                case 2:
                case 3:
                case 4:
                    validInput = true;
                    break;
                default:
                    validInput = false;
                    break;
            }
        }
        return input;
    }

    //*****************************METHODS END**************************************
    public static void main(String[] args) {
        int input;
        kbd = new Scanner(System.in);
        //initialize loop control variables
        boolean sameUser;
        boolean newUser = true;

        //get information for current user
        while (newUser) {
            //get height
            System.out.println("Enter your height (in inches): ");
            int height = kbd.nextInt();
            //get weight
            System.out.println("Enter your weight (in pounds): ");
            int weight = kbd.nextInt();
            //get age
            System.out.println("Enter your age (in years): ");
            int age = kbd.nextInt();
            System.out.println();

            //start inner loop
            sameUser = true;

            while (sameUser) {
                input = menu();
                switch (input) {
                    case 1:
                        //display hat size
                        System.out.println("Your hat size is: " + String.format("%.3f", hatSize(weight, height)) + " inches");
                        break;
                    case 2:
                        //display jacket size
                        System.out.println("Your jacket size is: " + String.format("%.3f", jacketSize(weight, height, age)) + " inches");
                        break;
                    case 3:
                        //display waist size
                        System.out.println("Your waist size is: " + String.format("%.3f", waistSize(weight, age)) + " inches");
                        break;
                    case 4:
                        //break inner loop
                        sameUser = false;
                        break;
                }
            }
            //check for a new user
            System.out.print("Calculate sizes for another person (Y/N)? ");
            String answer = kbd.next().toUpperCase();
            newUser = answer.equals("Y");
        }
        kbd.close();
    }
}
