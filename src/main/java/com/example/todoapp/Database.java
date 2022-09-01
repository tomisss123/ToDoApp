package com.example.todoapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static void main(String[] args) {


        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://db4free.net:3306/javatestproje",
                             "ayumuumuya",
                             "Javatestproject"
                     )) {

            Statement statement = connection.createStatement();
            String mySql = """
                    CREATE TABLE IF NOT EXISTS testowy_stol(
                    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                    message VARCHAR(255) )
                    """;
            statement.executeUpdate(mySql);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
