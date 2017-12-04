package org.gehennas.granuaile.database;

import org.gehennas.granuaile.PrepareException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private final String connectionString;

    private Connection dbConnection;

    public DatabaseConnector(String connectionString) {
        this.connectionString = connectionString;
    }

    public void initialize() throws PrepareException{
        try {
            dbConnection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            throw new PrepareException(e);
        }
    }

    public Connection getDbConnection() {
        return this.dbConnection;
    }

    public void tearDown() {
        if (dbConnection!=null) {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
