package com.example.todoapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import static javafx.application.Application.launch;

public class HelloController {
    @FXML
    Button button;


    @FXML
    private Label welcomeText;

    public HelloController() {

    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}