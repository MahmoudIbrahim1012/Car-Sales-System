package com.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Menus.mainMenu();
        String path = "C:\\Users\\Dell\\IdeaProjects\\Car Sales System\\Users.csv";
        BufferedReader br;

        {
            try {
                br = new BufferedReader(new FileReader(path));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
