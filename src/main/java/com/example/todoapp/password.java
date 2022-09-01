package com.example.todoapp;


public class password {
    public static String secretMessage(String password) {
        if (password.equals("hasło")) {
            System.out.println("Witaj. Proszę podaj hasło!");
        } else {
            System.out.println("Błędne hasło");
        }
        return password;


    }

}
