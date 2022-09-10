package com.example.todoapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class TaskView extends LoginToApp {
    public TaskView(String userLogin) {
        super(userLogin);
    }
    public static void TaskViewer(Connection connection) throws SQLException {
        String sql = "SELECT * FROM '"+getUserLogin()+"'";
//trzeba zrobić wyświetlanie na konsoli id, name oraz description
    }
}
