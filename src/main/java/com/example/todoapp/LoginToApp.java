package com.example.todoapp;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.Scanner;

public class LoginToApp {
    private static String userLogin;

    public LoginToApp(String userLogin) {
    LoginToApp.userLogin = userLogin;
    }

    public static String getUserLogin() {
        return userLogin;
    }

    public static boolean Login() {
        Scanner scanner = new Scanner(System.in);
        boolean result = false;

        int tries = 3;

       while(tries!=0) {
           System.out.println("Pozostałe próby logowania: " + tries);

           try (Connection connection = DriverManager.getConnection(
                   "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11516654",
                   "sql11516654",
                   "XTippNpiYJ");) {
               System.out.println("Podaj login");
               userLogin = scanner.nextLine();
               System.out.println("Podaj hasło");
               String userPass = scanner.nextLine();


               Statement statement = connection.createStatement();
               String sqlPassword = "SELECT password FROM user_data WHERE  login = '" + userLogin + "'";
               ResultSet resultSet = statement.executeQuery(sqlPassword);
               if (resultSet != null && resultSet.next()) {
                   if (BCrypt.checkpw(userPass, resultSet.getString("password"))) {
                       System.out.println("logowanie udane");
                       result = true;
                       return result;
                   }
//                   else {
//                       System.out.println("Błędne hasło");
//                       result = false;
//                       return result;
//                   }
               }
               tries--;

           } catch (SQLException e) {
           }
           System.out.println("Błędny login lub hasło");

        }
        return result;
    }
}