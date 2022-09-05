package com.example.todoapp;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.Scanner;

public class LoginToApp {
    public static boolean Login() {
        Scanner scanner = new Scanner(System.in);
        boolean result = false;
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11516654",
                "sql11516654",
                "XTippNpiYJ");) {
            System.out.println("Podaj login");
            String userLogin = scanner.next();
            System.out.println("Podaj hasło");
            String userPass = scanner.next();


            Statement statement = connection.createStatement();
            String sqlPassword = "SELECT password FROM user_data WHERE  login = '"+userLogin+"'";
            ResultSet resultSet = statement.executeQuery(sqlPassword);
            if (resultSet != null && resultSet.next()) {
                if (BCrypt.checkpw(userPass,  resultSet.getString("password"))){
               System.out.println("logowanie udane");
           result = true;
           return result;
           }else {
               System.out.println("Błędne hasło");
           }

            }
        } catch (SQLException e) {
        }
        return result;
    }
}