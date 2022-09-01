package com.example.todoapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ToDoAppMain {


    public static void createTableUser(Connection connection, String name) throws SQLException {
        Statement statement = connection.createStatement();
        String mySql = """
                CREATE TABLE IF NOT EXISTS name(
                 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                 name VARCHAR(128) NOT NULL,
                surname VARCHAR(255) NOT NULL,
                 login VARCHAR(128) NOT NULL UNIQUE,
                password CHAR(60) NOT NULL,
                 email VARCHAR(255) UNIQUE
                 )
                 """;
        statement.executeUpdate(mySql);
    }

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://db4free.net:3306/javatestproje",
                             "ayumuumuya",
                             "Javatestproject"

                     )) {
            createDatabase(connection, "user");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
