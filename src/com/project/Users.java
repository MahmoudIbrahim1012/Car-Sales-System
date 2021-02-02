package com.project;

import java.io.*;

public class Users {
    String username;
    String password;
    static String path = "C:\\Users\\Dell\\IdeaProjects\\Car Sales System\\Users.csv";

    public static int signIn(String username, String password) {
        String line;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");
                if (values[0].equals(username) && values[1].equals(password)) {
                    return 1; // Returning 1 as in successful login
                } else if (values[0].equals(username)) {
                    System.out.println("Incorrect Password.");
                    return 0; // Returning 0 means unsuccessful login
                } else if (username.equals("e") && password.equals("e")) {
                    System.out.println("Returning to main menu.");
                    return 2; // Returning 2 means returning to main menu
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Incorrect username.");
        return 0;
    }

    public static void signUp(String username, String password) {
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(new File(path), true));
            bw.write(username + "," + password + "," + "0");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
