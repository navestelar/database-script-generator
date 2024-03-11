package com.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfiguration {
  private static final String CONFIG_FILE = "/app.config";
  private static AppConfiguration instance;
  private Properties propriedades;

  private AppConfiguration() {
    propriedades = new Properties();
    try (InputStream file = getClass().getResourceAsStream(CONFIG_FILE)) {
      if (file == null) {
        throw new IllegalArgumentException("File not found! " + CONFIG_FILE);
      }
      propriedades.load(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static AppConfiguration getInstance() {
    if (instance == null) {
      synchronized (AppConfiguration.class) {
        if (instance == null) {
          instance = new AppConfiguration();
        }
      }
    }
    return instance;
  }

  public String getProperty(String chave) {
    return propriedades.getProperty(chave);
  }
}
