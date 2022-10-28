package com.example.guice.component;

import com.google.inject.Inject;

public class StringWrapper {

  @Inject
  private String str;

  public String getStr() {
    return str;
  }

}
