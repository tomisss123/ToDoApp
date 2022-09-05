package com.example.todoapp;

import org.mindrot.jbcrypt.BCrypt;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;
import java.util.Scanner;

public class ToDoAppMain {


    public static void Registration(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String mySql = "CREATE TABLE IF NOT EXISTS user_data ( id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(128) NOT NULL, surname VARCHAR(255) NOT NULL, login VARCHAR(128) NOT NULL UNIQUE, password CHAR(60) NOT NULL, email VARCHAR(255) UNIQUE)";
        statement.executeUpdate(mySql);
        Scanner scanner = new Scanner(System.in);
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
    }

    public static void UserList(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        try (Connection connection1 = DriverManager.getConnection(
                    "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11516654",
                    "sql11516654",
                    "XTippNpiYJ");){


            Statement statement = connection.createStatement();
            String sqlPassword = "SELECT password FROM user_data WHERE id = 1";
            ResultSet resultSet = statement.executeQuery(sqlPassword);
            if (resultSet != null && resultSet.next()){
                System.out.println(resultSet.getString("password"));

            }
//            String password = resultSet.getString("password");
//            System.out.println(password);
//            System.out.println("Podaj login");
//            String login = scanner.next();
//            System.out.println("Podaj hasło");
        } catch (SQLException e) {
            System.out.println(e);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);

            pw.append("+++Start printing trace:\n");
            e.printStackTrace(pw);
            pw.append("---Finish printing trace");
            System.out.println(sw.toString());
        }
//        String userPassword = scanner.next();
//        if(password==)
//        Statement statement = connection.createStatement();
//        String mySQL = "CREATE TABLE IF NOT EXISTS "
    }

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11516654",
                             "sql11516654",
                             "XTippNpiYJ"

                     );) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Logowanie - 1\nRejestracja - 2");
            String number = scanner.next();
            if (number.equals("2")) {
                Registration(connection);
            } else if (number.equals("1")) {
                UserList(connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
