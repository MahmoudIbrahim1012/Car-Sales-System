package com.project;

import java.util.Scanner;

public class Menus {

    public static void mainMenu() {
        Scanner input = new Scanner(System.in);
        System.out.print("""
                ---------- CAR SALES SYSTEM -----------
                1 - SIGN IN
                2 - SIGN UP
                """);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                int isLogged = 0;
                while (isLogged == 0) {
                    System.out.println("If you want to go back to main menu, type e in both username and password.");
                    System.out.print("Enter Username: ");
                    String username = input.next();
                    System.out.print("Enter password: ");
                    String password = input.next();
                    isLogged = Users.signIn(username, password);
                    if (isLogged == 2)
                        mainMenu();
                }
                break;
            case 2:
                // sign up function
                break;
            default:
                System.out.println("Invalid input. ");
        }
    }
}
