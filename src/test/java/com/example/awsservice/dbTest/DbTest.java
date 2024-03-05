package com.example.awsservice.dbTest;


import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DbTest {
    @Test
    public void testDatabaseConnection() {
        // Create a variable for the connection string
        Connection connection = null;
        // Create variables for the connection
        try {
            String url = "jdbc:mysql://aws-sql-db.ctc6mqa8c0sz.eu-north-1.rds.amazonaws.com:3306/aws-sql-db";
            String username = "root";
            String password = "Kerimadmin";

            // Attempt to connect
            connection = DriverManager.getConnection(url, username, password);
            assertNotNull(connection);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFailedDatabaseConnection() {
        // Create a variable for the connection string
        Connection connection = null;
        // Create variables for the connection
        try {
            String url = "jdbc:mysql://aws-sql-db.ctc6mqa8c0sz.eu-north-1.rds.amazonaws.com:3306/aws-sql-db";
            String username = "root";
            String password = "root";

            // Attempt to connect
            connection = DriverManager.getConnection(url, username, password);
            assertNotNull(connection);

            System.out.println("Connected to the database.");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}

