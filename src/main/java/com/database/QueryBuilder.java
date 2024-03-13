package com.database;

public interface QueryBuilder {
  QueryBuilder createDatabase(String databaseName);
  QueryBuilder createTable(String tableName);
  QueryBuilder addColumn(String columnName, String columnType);
}
