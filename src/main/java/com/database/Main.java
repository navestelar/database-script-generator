package com.database;

public class Main {
    public static void main(String[] args) {
        AppConfiguration config = AppConfiguration.getInstance();
        System.out.println("Database URL: " + config.getProperty("database.url"));
        System.out.println("Database User: " + config.getProperty("database.user"));
        System.out.println("Database Password: " + config.getProperty("database.password"));
    }
}