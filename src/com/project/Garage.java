package com.project;

import java.io.*;
import java.util.Scanner;

public class Garage extends File_control {
    String path = "Data.csv";
    String line = "";
    String[][] values = new String[100][11];
    int car_num = 1;
    Scanner input = new Scanner(System.in);
    BufferedReader br = null;
    //final ThreadLocal<Menus> menus = ThreadLocal.withInitial(Menus::new);

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

            car_num++;
        }
    }

    public int next() {
        System.out.print("""
                1 - search.
                2 - buy.
                3 - view.
                4 - log out
                enter your choice: """);
        int choice = input.nextInt();
        if (choice == 1) {
            search_type();
            return 0;
        } else if (choice == 2) {
            buy();
            return 0;
        } else if (choice == 3) {
            view();
            return 0;
        } else if (choice == 4) {
            //menus.get().mainMenu();
            return 1;
        } else {
            System.out.println("invalid input , please try again.");
            next();
            return 0;
        }

    }

    void view() {
        for (int i = 1; i < car_num; i++) {
            System.out.println(
                    "\n car id: " + values[i][0] +
                            "\n brand : " + values[i][1] +
                            "\n model : " + values[i][2] +
                            "\n Condition :" + values[i][3] +
                            "\n year of purchase : " + values[i][4] +
                            "\n Transmission :" + values[i][5] +
                            "\n Engine Capacity" + values[i][6] +
                            "\n colors : " + values[i][7] +
                            "\n Body_type :" + values[i][8] +
                            "\n price : " + values[i][9] +
                            "\n available : " + values[i][10] +
                            "\n  __________________________________________________________");
        }
        next();
    }

    void search_type() {
        Scanner input = new Scanner(System.in);
        System.out.print("""
                 *********************************************************
                1 - search by manufacturer type.
                2 - search by year of purchase.
                3 - search by cost.
                type your choice : """);
        String c1 = input.next();
        if (c1.equals("1")) {
            System.out.print("type required manufacturer type : ");
            String c2 = input.next();
            search(c2);
        } else if (c1.equals("2")) {
            System.out.println("before : ");
            String c2 = input.next();
            if (is_number(c2)) {
                search(Integer.parseInt(c2));
            } else {
                System.out.println("invalid input , please try again.");
                search_type();
            }
        } else if (c1.equals("3")) {
            System.out.println("minimum price : ");
            String c2 = input.next();
            if (!is_number(c2)) {
                System.out.println("invalid input , please try again.");
                search_type();
            }
            System.out.println("maximum price : ");
            String c3 = input.next();
            if (!is_number(c3)) {
                System.out.println("invalid input , please try again.");
                search_type();
            }
            search(Integer.parseInt(c2), Integer.parseInt(c3));


        } else {
            System.out.println("invalid input , please try again.");
            search_type();
        }
    }

    void search(String brand) {
        boolean found = false;
        for (int i = 1; i < car_num; i++) {
            if (brand.equalsIgnoreCase(values[i][1])) {
                found = true;
                System.out.println(
                        "\n car id: " + values[i][0] +
                                "\n brand : " + values[i][1] +
                                "\n model : " + values[i][2] +
                                "\n Condition :" + values[i][3] +
                                "\n year of purchase : " + values[i][4] +
                                "\n Transmission :" + values[i][5] +
                                "\n Engine Capacity" + values[i][6] +
                                "\n colors : " + values[i][7] +
                                "\n Body_type :" + values[i][8] +
                                "\n price : " + values[i][9] +
                                "\n available : " + values[i][10] +
                                "\n  __________________________________________________________");
            }

        }
        if (!found) {
            System.out.println("no results , please try again.");
            search_type();
        } else {
            next();
        }
    }

    void search(int year) {
        boolean found = false;
        for (int i = 1; i < car_num; i++) {
            if (year >= Integer.parseInt(values[i][4])) {
                found = true;
                System.out.println(
                        "\n car id: " + values[i][0] +
                                "\n brand : " + values[i][1] +
                                "\n model : " + values[i][2] +
                                "\n Condition :" + values[i][3] +
                                "\n year of purchase : " + values[i][4] +
                                "\n Transmission :" + values[i][5] +
                                "\n Engine Capacity" + values[i][6] +
                                "\n colors : " + values[i][7] +
                                "\n Body_type :" + values[i][8] +
                                "\n price : " + values[i][9] +
                                "\n available : " + values[i][10] +
                                "\n  __________________________________________________________");
            }
        }
        if (!found) {
            System.out.println("no results , please try again.");
            search_type();
        } else {
            next();
        }
    }

    void search(int min, int max) {
        boolean found = false;
        for (int i = 1; i < car_num; i++) {
            found = true;
            if (min <= Integer.parseInt(values[i][9]) && max >= Integer.parseInt(values[i][9])) {
                System.out.println(
                        "\n car id: " + values[i][0] +
                                "\n brand : " + values[i][1] +
                                "\n model : " + values[i][2] +
                                "\n Condition :" + values[i][3] +
                                "\n year of purchase : " + values[i][4] +
                                "\n Transmission :" + values[i][5] +
                                "\n Engine Capacity" + values[i][6] +
                                "\n colors : " + values[i][7] +
                                "\n Body_type :" + values[i][8] +
                                "\n price : " + values[i][9] +
                                "\n available : " + values[i][10] +
                                "\n  __________________________________________________________");
            }
        }
        if (!found) {
            System.out.println("no results , please try again.");
            search_type();
        } else {
            next();
        }
    }

    void buy() {
        System.out.print("type car id you want to buy : ");
        String id = input.next();
        if (!is_number(id)) {
            System.out.println("invalid input , please try again.");
            buy();
        }
        boolean found = false;
        for (int i = 1; i < car_num; i++) {
            if (Integer.parseInt(id) == Integer.parseInt(values[i][0])) {
                found = true;
                System.out.println(
                        "\n car id: " + values[i][0] +
                                "\n brand : " + values[i][1] +
                                "\n model : " + values[i][2] +
                                "\n Condition :" + values[i][3] +
                                "\n year of purchase : " + values[i][4] +
                                "\n Transmission :" + values[i][5] +
                                "\n Engine Capacity" + values[i][6] +
                                "\n colors : " + values[i][7] +
                                "\n Body_type :" + values[i][8] +
                                "\n price : " + values[i][9] +
                                "\n available : " + values[i][10] +
                                "\n  __________________________________________________________\n");
                if (Integer.parseInt(values[i][10]) > 0) {
                    System.out.println("\n the car was bought successfully\n");
                    values[i][10] = String.valueOf(Integer.parseInt(values[i][10]) - 1);
                    file_setter();
                } else {
                    System.out.println("sorry, this car is not available now please try again later.");
                }
            }

        }
        if (!found) {
            System.out.println("no results , please try again.");
            buy();
        }
        next();
    }

    void file_setter() {
        try {
            PrintWriter pw = new PrintWriter(new File("Data.csv"));

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < car_num; i++) {
                for (int j = 0; j < 11; j++) {
                    sb.append(values[i][j]);
                    if (j < 10) {
                        sb.append(",");
                    }
                }
                sb.append("\r\n");
            }
            pw.write(sb.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    boolean is_number(String x) {
        try {
            Integer.parseInt(x);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}