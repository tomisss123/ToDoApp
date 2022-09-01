package com.example.todoapp;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
 public static void main(String[] args) {

  try {
   DriverManager.getConnection(
           "jdbc:mysql://db4free.net:3306/javatestproje",
           "root",
           "Grupa03!"
   );
  } catch (SQLException e) {
   throw new RuntimeException(e);
  }
 }

}
