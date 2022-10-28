package com.example.guice.component.impl;

import com.example.guice.component.Driver;

public class DefaultDriver implements Driver {
  private final String name;

  public DefaultDriver() {

    this.name = "Tom";
  }

  public void drive() {
    System.out.printf("Default driver %s is driving\n", name);
  }
}
