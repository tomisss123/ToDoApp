module com.example.todoapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires jbcrypt;


    opens com.example.todoapp to javafx.fxml;
    exports com.example.todoapp;
}