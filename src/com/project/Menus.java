package com.project;
import java.util.Scanner;
public class Menus {
    public Menus()
    {
        //mainMenu();
    }
    Users users = new Users();
    Garage garage = new Garage();
    Car car = new Car();
    public void mainMenu() {
        Scanner input = new Scanner(System.in);
        System.out.print("""
                ---------- CAR SALES SYSTEM -----------
                1 - SIGN IN
                2 - SIGN UP
                enter your choice : """);
        int choice = input.nextInt();
        switch (choice) {
            case 1 -> {
                int isLogged = 0;
                while (isLogged == 0) {
                    System.out.println("If you want to go back to main menu, type e in both username and password.");
                    System.out.print("Enter Username: ");
                    String username = input.next();
                    System.out.print("Enter password: ");
                    String password = input.next();
                    isLogged = users.signIn(username, password);
                    if (isLogged == 1)
                        mainMenu();
                    else if (isLogged == 2)
                        garage.next();
                    else if (isLogged == 3)
                        car.next();
                }
            }
            case 2 -> {
                System.out.print("Enter Username: ");
                String username = input.next();
                System.out.print("Enter password: ");
                String password = input.next();
                users.signUp(username, password);
            }
            default -> System.out.println("Invalid input. ");
        }
    }
}
