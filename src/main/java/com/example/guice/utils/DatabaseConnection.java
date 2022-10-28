package com.example.guice.utils;

import java.util.logging.Logger;

import com.google.inject.Inject;

public class DatabaseConnection {
  @Inject
  Logger logger;

  @Inject
  public DatabaseConnection() {
    logger.info("DatabaseConnection init");
  }
}
