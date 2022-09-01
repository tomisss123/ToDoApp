module com.example.todoapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.todoapp to javafx.fxml;
    exports com.example.todoapp;
}