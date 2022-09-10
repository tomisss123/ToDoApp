package com.example.todoapp;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoAppMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        int userChoice1;
        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11516654",
                             "sql11516654",
                             "XTippNpiYJ"

                     );) {

            System.out.println("Logowanie - 1\nRejestracja - 2");
            userChoice= scanner.nextInt();
            if (userChoice == 2) {
                RegisterToApp.Registration(connection);

            } else if(userChoice==1) {
                if(LoginToApp.Login()==true){
                    TaskAdd.TaskAdder(connection);
                }

            }else{
                System.out.println("Musisz wprowadzić '1' lub '2'");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InputMismatchException e) {
            throw new RuntimeException("Musisz wprowadzić '1' lub '2'");
        }
    }
}

