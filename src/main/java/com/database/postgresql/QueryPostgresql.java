package com.database.postgresql;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.QueryBuilder;
import com.database.connection.ConnectionFactory;
import com.database.connection.DatabaseConnection;
import com.database.connection.DatabaseType;

public class QueryPostgresql implements QueryBuilder {
  private DatabaseConnection connection;
  private StringBuilder queryBuilder;

  public QueryPostgresql(DatabaseType databaseType) throws SQLException {
    this.connection = ConnectionFactory.setDatabaseConnection(databaseType);
    this.queryBuilder = new StringBuilder();
  }

  @Override
  public QueryBuilder addColumn(String columnName, String columnType) {
    queryBuilder.append(columnName).append(" ").append(columnType).append(",");
    return this;
  }

  @Override
  public QueryBuilder createDatabase(String databaseName) {
    queryBuilder.append("CREATE DATABASE ").append(databaseName).append(";\n");
    queryBuilder.append("USE ").append(databaseName).append(";\n");
    return this;
  }

  @Override
  public QueryBuilder createTable(String tableName) {
    queryBuilder.append("CREATE TABLE ").append(tableName).append(" (\n");
    return this;
  }
}
