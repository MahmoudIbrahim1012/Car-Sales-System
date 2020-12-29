package com.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Garage {

    String path = "C:\\Users\\user\\IdeaProjects\\Car-Sales-System\\Data.csv";
    String line = "";
    String[][] values = new String[51][11];
    int car_num = 1;
    Scanner input = new Scanner(System.in);
    BufferedReader br = null;

    public Garage() {
        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                assert br != null;
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] temporary = line.split(",");
            for (int i = 0; i < temporary.length; i++) {
                values[car_num][i] = temporary[i];
            }
            values[car_num][10] = String.valueOf(car_num);
            System.out.println("----------------------------------------------------------\n" +

                    "\n brand : " + values[car_num][0] +
                    "\n model : " + values[car_num][1] +
                    "\n Condition :" + values[car_num][2] +
                    "\n year of purchase : " + values[car_num][3] +
                    "\n Transmission :" + values[car_num][4] +
                    "\n Engine Capacity" + values[car_num][5] +
                    "\n colors : " + values[car_num][6] +
                    "\n Body_type :" + values[car_num][7] +
                    "\n price : " + values[car_num][8] +
                    "\n available : " + values[car_num][9] +
                    "\n car id: " + values[car_num][10] +
                    "\n  __________________________________________________________");

            car_num++;
        }
        //System.out.println(car_num);
        next();
    }

    public void next() {
        //Scanner input = new Scanner(System.in);
        System.out.print("""
                1 - search.
                2 - buy.
                enter your choice : 
                """);
        int choice = input.nextInt();

        if (choice == 1) {
            search_type();
        } else if (choice == 2) {
            buy();
        } else {
            System.out.println("invalid input , please try again.");
            next();
        }

    }

    public void search_type() {
        Scanner input = new Scanner(System.in);
        System.out.print("""
                 *********************************************************
                1 - search by manufacturer type.
                2 - search by year of purchase.
                3 - search by cost.
                type your choice : 
                """);
        int c1 = input.nextInt();
        if (c1 == 1) {
            System.out.print("type required manufacturer type : ");
            String c2 = input.next();
            search(c2);

        } else if (c1 == 2) {
            System.out.println("before : ");
            int c2 = input.nextInt();
            search(c2);
        } else if (c1 == 3) {
            System.out.println("minimum price : ");
            int c2 = input.nextInt();
            System.out.println("maximum price : ");
            int c3 = input.nextInt();
            search(c2, c3);


        } else {
            System.out.println("invalid input , please try again.");
            search_type();
        }
    }

    public void search(String brand) {
        boolean found = false;
        for (int i = 1; i < car_num; i++) {
            if ((brand.toLowerCase()).equals(values[i][0].toLowerCase())) {
                found = true;
                System.out.println(
                        "\n car id: " + i +
                                "\n brand : " + values[i][0] +
                                "\n model : " + values[i][1] +
                                "\n Condition :" + values[i][2] +
                                "\n year of purchase : " + values[i][3] +
                                "\n Transmission :" + values[i][4] +
                                "\n Engine Capacity" + values[i][5] +
                                "\n colors : " + values[i][6] +
                                "\n Body_type :" + values[i][7] +
                                "\n price : " + values[i][8] +
                                "\n available : " + values[i][9] +
                                "\n  __________________________________________________________");
            }

        }
        if (!found) {
            System.out.println("no results , please try again.");
            search_type();
        } else {
            after_search();
        }
    }

    public void search(int year) {
        boolean found = false;
        for (int i = 1; i < car_num; i++) {
            if (year >= Integer.parseInt(values[i][3])) {
                found = true;
                System.out.println("\n  __________________________________________________________" +
                        "\n car id: " + i +
                        "\n brand : " + values[i][0] +
                        "\n model : " + values[i][1] +
                        "\n Condition :" + values[i][2] +
                        "\n year of purchase : " + values[i][3] +
                        "\n Transmission :" + values[i][4] +
                        "\n Engine Capacity" + values[i][5] +
                        "\n colors : " + values[i][6] +
                        "\n Body_type :" + values[i][7] +
                        "\n price : " + values[i][8] +
                        "\n available : " + values[i][9] +
                        "\n  __________________________________________________________");
            }
        }
        if (!found) {
            System.out.println("no results , please try again.");
            search_type();
        } else {
            after_search();
        }
    }

    public void search(int min, int max) {
        boolean found = false;
        for (int i = 1; i < car_num; i++) {
            found = true;
            if (min <= Integer.parseInt(values[i][8]) && max >= Integer.parseInt(values[i][8])) {
                System.out.println("\n  __________________________________________________________" +
                        "\n car id: " + i +
                        "\n brand : " + values[i][0] +
                        "\n model : " + values[i][1] +
                        "\n Condition :" + values[i][2] +
                        "\n year of purchase : " + values[i][3] +
                        "\n Transmission :" + values[i][4] +
                        "\n Engine Capacity" + values[i][5] +
                        "\n colors : " + values[i][6] +
                        "\n Body_type :" + values[i][7] +
                        "\n price : " + values[i][8] +
                        "\n available : " + values[i][9] +
                        "\n  __________________________________________________________");
            }
        }
        if (!found) {
            System.out.println("no results , please try again.");
            search_type();
        } else {
            after_search();
        }
    }

    public void after_search() {
        System.out.print("""
                1 - search again.
                2 - buy a car.
                type your choice :  
                """);
        int c1 = input.nextInt();
        if (c1 == 1) {
            search_type();
        }
        else if (c1 == 2) {
            buy();
        }
        else {
            System.out.println("invalid input , please try again.");
            after_search();
        }
    }

    public void buy()
    {
        System.out.print("type car id you want to buy : ");
        int id = input.nextInt();
        boolean found = false;
        for (int i = 1; i < car_num; i++) {
            if (id == Integer.parseInt(values[i][10]))
            {
                found = true;
                System.out.println("\n  __________________________________________________________" +
                        "\n car id: " + i +
                        "\n brand : " + values[i][0] +
                        "\n model : " + values[i][1] +
                        "\n Condition :" + values[i][2] +
                        "\n year of purchase : " + values[i][3] +
                        "\n Transmission :" + values[i][4] +
                        "\n Engine Capacity" + values[i][5] +
                        "\n colors : " + values[i][6] +
                        "\n Body_type :" + values[i][7] +
                        "\n price : " + values[i][8] +
                        "\n available : " + values[i][9] +
                        "\n  __________________________________________________________");
                if(Integer.parseInt(values[i][9]) > 0)
                {
                    System.out.print("\n the car was bought successfully");
                    values[i][9]= String.valueOf(Integer.parseInt(values[i][9])-1);
                }
                else
                {
                    System.out.println("sorry, this car is not available now please try again later.");
                }
            }

        }
        if (!found){
        System.out.println("no results , please try again.");
        buy();
    }
    }
}

