package com.example.todoapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Scanner;

public class TaskAdd extends LoginToApp {

    public TaskAdd(String userLogin) {
        super(userLogin);
    }

    public static void TaskAdder(Connection connection) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        int userChoice;

        do {
            System.out.println("Dodaj taska - 1\nWyjdź - 2");
            userChoice = scanner.nextInt();
            if (userChoice == 1) {
                String mySql = "CREATE TABLE IF NOT EXISTS " + getUserLogin() + " ( id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(128) NOT NULL, description VARCHAR(1024))";
                Statement statement = connection.createStatement();
                System.out.println("Podaj nazwę taska:");
                Scanner scanner1 = new Scanner(System.in);
                String taskName = scanner1.nextLine();
                System.out.println("Podaj opis taska:");
                Scanner scanner2 = new Scanner(System.in);
                String taskDescription = scanner2.nextLine();
                statement.executeUpdate(mySql);
                String mySql4 = "INSERT INTO " + getUserLogin() + "(name, description) VALUES('" + taskName + "','" + taskDescription + "')";
                statement.executeUpdate(mySql4);
            }
        }
        while (userChoice != 2);
    }
}
