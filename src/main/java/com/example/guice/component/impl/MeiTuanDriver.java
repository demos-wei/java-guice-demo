package com.example.guice.component.impl;

import com.example.guice.component.Driver;
import com.google.inject.Inject;

public class MeiTuanDriver implements Driver {
  private final String name;

  @Inject
  public MeiTuanDriver() {this.name = "Jim";}

  @Override
  public void drive() {
    System.out.printf("MeiTuan driver %s is driving\n", name);
  }
}
