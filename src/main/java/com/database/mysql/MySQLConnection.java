package com.database.mysql;

import com.database.AppConfiguration;
import com.database.connection.DatabaseConnection;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLConnection implements DatabaseConnection {

    private static MySQLConnection instance;
    private final HikariDataSource dataSource;

    private MySQLConnection() throws SQLException {
        AppConfiguration appConfig = AppConfiguration.getInstance();
        String url = appConfig.getProperty("database.url");
        String user = appConfig.getProperty("database.user");
        String password = appConfig.getProperty("database.password");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(30000);

        dataSource = new HikariDataSource(config);
    }

    public static synchronized MySQLConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new MySQLConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeDataSource() throws SQLException {
        if (instance != null) {
            instance.dataSource.close();
        }
    }
}
