package com.database.connection;

import java.sql.SQLException;

import com.database.mysql.MySQLConnection;
import com.database.postgresql.PostgreSQLConnection;

public class ConnectionFactory {
  public static DatabaseConnection setDatabaseConnection(DatabaseType databaseType) throws SQLException {
    switch (databaseType) {
      case POSTGRESQL:
        return PostgreSQLConnection.getInstance();
      case MYSQL:
        return MySQLConnection.getInstance();
    }
    return null;
  }
}
