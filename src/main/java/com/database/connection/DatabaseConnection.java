package com.database.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {
  Connection getConnection() throws SQLException;
  void closeDataSource() throws SQLException;
}
