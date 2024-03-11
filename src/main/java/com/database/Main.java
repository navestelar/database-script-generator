package com.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.database.connection.ConnectionFactory;
import com.database.connection.DatabaseConnection;
import com.database.connection.DatabaseType;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseConnection dbConnection = ConnectionFactory.setDatabaseConnection(DatabaseType.POSTGRESQL);
            Connection connection = dbConnection.getConnection();
            // Use the connection...
            dbConnection.closeDataSource();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
