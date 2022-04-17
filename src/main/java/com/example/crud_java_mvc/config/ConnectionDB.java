package com.example.crud_java_mvc.config;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;

public class ConnectionDB {

    InitialContext initialContext;

    Connection connection;

    public ConnectionDB() {
        try {
            initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/ConnetionMySQL");
            connection = dataSource.getConnection();

            /*
            Old singleton connection
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage", "root", "1234");*/

        } catch (Exception ex) {
            System.err.println("error" + ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
