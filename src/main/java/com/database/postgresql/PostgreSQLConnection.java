package com.database.postgresql;

import com.database.AppConfiguration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgreSQLConnection {

    private static PostgreSQLConnection instance;
    private final HikariDataSource dataSource;
    
    private PostgreSQLConnection() throws SQLException {
        AppConfiguration appConfig = AppConfiguration.getInstance();
        String url = appConfig.getProperty("database.url");
        String user = appConfig.getProperty("database.user");
        String password = appConfig.getProperty("database.password");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.setDriverClassName("org.postgresql.Driver");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(30000);

        dataSource = new HikariDataSource(config);
    }

    public static synchronized PostgreSQLConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new PostgreSQLConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closeDataSource() throws SQLException {
        if (instance != null) {
            instance.dataSource.close();
        }
    }
}
