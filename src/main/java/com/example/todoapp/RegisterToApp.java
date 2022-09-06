package com.example.todoapp;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RegisterToApp {
    public static void Registration (Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj imię:");
            String name = scanner.next();
            System.out.println("Podaj nazwisko:");
            String surname = scanner.next();
            System.out.println("Podaj e-mail:");
            String email = scanner.next();
            System.out.println("Podaj login:");
            String login = scanner.next();
            System.out.println("Podaj hasło:");
            String password = scanner.next();

            password = BCrypt.hashpw(password, BCrypt.gensalt());
            String mySql2 = "INSERT INTO user_data (name, surname, login, password, email) VALUES('" + name + "','" + surname + "','" + login + "','" + password + "','" + email + "')";
            statement.executeUpdate(mySql2);

            System.out.println("Rejestracja zakończona pomyślnie!");

        }
    }
