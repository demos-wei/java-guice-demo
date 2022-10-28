package com.example.guice.component.impl;

import com.example.guice.annotation.LogInvoke;
import com.example.guice.component.Packager;
import com.google.inject.Inject;

public class DefaultPackager implements Packager {

  private final String material;

  public DefaultPackager(String material) {
    this.material = material;
  }

  @Override
  @LogInvoke
  public void pack(String target) {
    System.out.printf("manual package %s with %s\n", target, material);
  }
}
