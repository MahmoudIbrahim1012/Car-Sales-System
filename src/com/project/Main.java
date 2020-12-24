package com.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("""
                ---------- CAR SALES SYSTEM -----------
                1 - SIGN IN
                2 - SIGN UP\s""");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                //sign in function
                break;
            case 2:
                // sign up function
                break;
            default:
                System.out.println("Invalid input. ");
        }


    }
}
