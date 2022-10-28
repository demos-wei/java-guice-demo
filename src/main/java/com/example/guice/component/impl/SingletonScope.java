package com.example.guice.component.impl;

import java.time.Instant;

import com.example.guice.component.Scope;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class SingletonScope implements Scope {
  private final long id;

  @Inject
  public SingletonScope() {
    this.id = Instant.now().toEpochMilli();
  }

  @Override
  public long getId() {
    return id;
  }
}
