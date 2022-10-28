package com.example.guice.module;

import com.example.guice.component.Scope;
import com.example.guice.component.impl.SingletonScope;
import com.google.inject.AbstractModule;

public class ScopeModule extends AbstractModule {
  @Override
  protected void configure() {

    try {
      bind(Scope.class).toConstructor(SingletonScope.class.getConstructor());
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }
}
