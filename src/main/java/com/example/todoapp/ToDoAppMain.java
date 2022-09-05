package com.example.todoapp;

import org.mindrot.jbcrypt.BCrypt;

import java.awt.desktop.ScreenSleepEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ToDoAppMain {


    public static void createTableUser(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String mySql = "CREATE TABLE IF NOT EXISTS user_data ( id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(128) NOT NULL, surname VARCHAR(255) NOT NULL, login VARCHAR(128) NOT NULL UNIQUE, password CHAR(60) NOT NULL, email VARCHAR(255) UNIQUE)";
        statement.executeUpdate(mySql);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Logowanie - 1\nRejestracja - 2");
        if (scanner.nextInt() == 2) {
            System.out.println("Podaj imię:");
            Scanner scanner1 = new Scanner(System.in);
            String name = scanner1.nextLine();
            System.out.println("Podaj nazwisko:");
            String surname = scanner1.nextLine();
            System.out.println("Podaj e-mail:");
            String email = scanner1.nextLine();
            System.out.println("Podaj login:");
            String login = scanner1.nextLine();
            System.out.println("Podaj hasło:");
            String password = scanner1.nextLine();

            password = BCrypt.hashpw(password, BCrypt.gensalt());
            String mySql2 = "INSERT INTO user_data (name, surname, login, password, email) VALUES('" + name + "','" + surname + "','" + login + "','" + password + "','" + email + "')";
            statement.executeUpdate(mySql2);

            Statement statement1 = connection.createStatement();
            String mySql3 = "CREATE TABLE IF NOT EXISTS " + login + " ( id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(128) NOT NULL, description VARCHAR(1024))";
            System.out.println("Rejestracja zakończona pomyślnie!");

            int userChoice;
            do {
                System.out.println("Dodaj taska - 1\nZakoncz program - 3");
                userChoice = scanner.nextInt();
                if (userChoice == 1) {
                    System.out.println("Podaj nazwę taska:");
                    Scanner scanner2 = new Scanner(System.in);
                    String taskName = scanner2.nextLine();
                    System.out.println("Podaj opis taska:");
                    Scanner scanner3 = new Scanner(System.in);
                    String taskDescription = scanner3.nextLine();
                    statement1.executeUpdate(mySql3);
                    String mySql4 = "INSERT INTO " + login + "(name, description) VALUES('" + taskName + "','" + taskDescription + "')";
                    statement1.executeUpdate(mySql4);
                }
            } while (userChoice != 3);


        }


    }

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11516654",
                             "sql11516654",
                             "XTippNpiYJ"

                     );) {
            createTableUser(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
