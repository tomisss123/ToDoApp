package com.example.todoapp;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ToDoAppMain {


    public static void createTableUser(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię:");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        String surname = scanner.nextLine();
        System.out.println("Podaj e-mail:");
        String email = scanner.nextLine();
        System.out.println("Podaj login:");
        String login = scanner.nextLine();
        System.out.println("Podaj hasło:");
        String password = scanner.nextLine();

//        password = BCrypt.hashpw(password, BCrypt.gensalt());


        Statement statement = connection.createStatement();
        String mySql = "CREATE TABLE IF NOT EXISTS user_data ( id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(128) NOT NULL, surname VARCHAR(255) NOT NULL, login VARCHAR(128) NOT NULL UNIQUE, password CHAR(60) NOT NULL, email VARCHAR(255) UNIQUE)";

        statement.executeUpdate(mySql);
        String mySql2 = "INSERT INTO user_data (name, surname, login, password, email) VALUES('" + name + "','" + surname + "','" + login + "','" + password + "','" + email + "')";
        statement.executeUpdate(mySql2);
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
