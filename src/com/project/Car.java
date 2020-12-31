package com.project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Car extends Garage {

    @Override
    public void next() {

        System.out.print("""
                1 - Search.
                2 - Delete.
                3 - Edit Price.
                4 - Add.
                enter your choice : 
                """);
        int choice = input.nextInt();

        if (choice == 1) {
            search_type();
        }
        else if (choice == 2) {
            delete(path);
        }
        else if (choice == 3) {
            edit(path);
        }
        else if (choice == 4) {
            add();
        }
        else {
            System.out.println("invalid input , please try again.");
            next();
        }

    }

    public int check(String id) {
        for (int i = 0; i < car_num; i++) {
            if (id.equals(values[i][0])) {
                return i;
            }
        }
        return -1;
    }

    public void delete(String Path) {
        System.out.println("please enter the car id you want to delete:");
        String id_checker = input.next();
        int k;
        if ((k = check(id_checker)) > 0) {
            for (; k < car_num -1; k++) {
                for (int j = 0; j < 11; j++) {
                    values[k][j] = values[k + 1][j];
                }
            }
            car_num--;
        } else {
            System.out.println("invalid input , please try again.");
            delete(path);
        }

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
            System.out.println("car has been deleted.");
            next();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void edit(String Path)
    {
        String check_id;
        String new_price;
        System.out.println("please enter the car id you want to edit");
        check_id=input.next();
        System.out.println("please enter the new price");
        new_price=input.next();
        boolean found = false;
        for (int i = 1; i < super.car_num; i++) {
            if (super.values[i][0]!=null) {
                if (check_id.equals(super.values[i][0])) {
                    found = true;
                    super.values[i][9] = new_price;

                }
            }
        }
        if (!found) {
            System.out.println("invalid input , please try again.");
            edit(path);

        } else {
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
            System.out.println("car has been updated");
            next();
        }

    }

    public void add(){
    //nada
    }
}













