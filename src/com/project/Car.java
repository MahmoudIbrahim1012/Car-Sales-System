package com.project;


public class Car extends Garage {
    public int next() {
        System.out.print("""
                1 - Search.
                2 - Delete.
                3 - Edit Price.
                4 - Add.
                5 - view.
                6 - log out
                enter your choice : """);
        String choice = input.next();

        if (choice.equals("1")) {
            search_type();
            return 0;
        }
        else if (choice.equals("2")) {
            delete(path);
            return 0;
        }
        else if (choice.equals("3")) {
            edit(path);
            return 0;
        }
        else if (choice.equals("4")) {
            add();
            return 0;
        }
        else if (choice.equals("5")) {
            view();
            return 0;
        }
        else if (choice.equals("6")) {
            //menus.get().mainMenu();
            return 1;
        }

        else {
            System.out.println("invalid input , please try again.");
            next();
            return 0;
        }
    }



    private String id_setter() {
        String id;
        boolean unique = true;
        if (is_number(id = input.next()))
        {
            for (int i = 1; i < car_num; i++) {
                if (id.equalsIgnoreCase(values[i][0])) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                return id;
            }
        }
        System.out.print("invalid input , please enter the car id again :");
        return id_setter();
    }

    private String year_setter() {
        String num;
        if (is_number(num = input.next())) {
            if (Integer.parseInt(num) <= 2021 && Integer.parseInt(num) > 1900) {
                return num;
            }
        }
        System.out.print("invalid input , please enter the car year again :");

        return year_setter();
    }

    private String price_or_available_setter() {
        String num;
        if (is_number(num = input.next())) {

            if (Integer.parseInt(num) > 0) {
                return num;
            }
        }
        System.out.print("invalid input , please enter your input again :");
        return price_or_available_setter();
    }

    private int check_id() {
        int id = input.nextInt();
        for (int i = 1; i < car_num; i++) {
            if (id == Integer.parseInt(values[i][0])) {
                return i;
            }
        }
        System.out.print("invalid input , please enter the car id again :");
        return check_id();
    }

    private void delete(String Path) {
        System.out.println("please enter the car id you want to delete:");
        for (int k = check_id(); k < car_num - 1; k++) {
            for (int j = 0; j < 11; j++) {
                values[k][j] = values[k + 1][j];
            }
        }
        car_num--;
        file_setter();
        System.out.println("car has been deleted.");
        next();

    }

    private void edit(String Path) {
        String check_id;
        String new_price;
        System.out.println("please enter the car id you want to edit");
        check_id = input.next();
        System.out.println("please enter the new price");
        new_price = input.next();
        boolean found = false;
        for (int i = 1; i < car_num; i++) {
            if (values[i][0] != null) {
                if (check_id.equals(values[i][0])) {
                    found = true;
                    values[i][9] = new_price;
                }
            }
        }
        if (!found) {
            System.out.println("invalid input , please try again.");
            edit(path);

        } else {
            file_setter();
            System.out.println("car has been updated");
            next();
        }
    }

    private void add() {
        String[] addfun = new String[11];
        System.out.print("please enter the car id you want to add : ");
        addfun[0] = id_setter();
        System.out.print(" brand : ");
        addfun[1] = input.next();
        System.out.print(" model : ");
        addfun[2] = input.next();
        System.out.print("Condition (Used/new) : ");
        addfun[3] = input.next();
        System.out.print(" year of purchase : ");
        addfun[4]= year_setter();
        System.out.print(" Transmission (Automatic/manual):" );
        addfun[5]= input.next();
        System.out.print(" Engine Capacity : " );
        addfun[6]= input.next();
        System.out.print(" colors : " );
        addfun[7]= input.next();
        System.out.print( " Body_type :" );
        addfun[8]= input.next();
        System.out.print("price : " );
        addfun[9]= price_or_available_setter();
        System.out.print(" available : " );
        addfun[10]= price_or_available_setter();
        car_num++;
        for (int i = 0; i < 11; i++) {
            values[car_num-1][i] = addfun[i];
        }
        file_setter();
        System.out.println("car has been added");
        next();
    }
}