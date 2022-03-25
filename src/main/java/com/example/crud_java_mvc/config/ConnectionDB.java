package com.example.crud_java_mvc.config;

import java.sql.*;

public class ConnectionDB {

    Connection connection;

    public ConnectionDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage", "root", "1234");
        } catch (Exception ex) {
            System.err.println("error" + ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
