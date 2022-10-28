package com.example.guice.component;

import java.util.Set;

import com.google.inject.Inject;

public class MultiBindWrapper {
  private final Set<Notifier> notifiers;

  @Inject
  public MultiBindWrapper(Set<Notifier> notifiers) {this.notifiers = notifiers;}

  public void doNotify() {
    notifiers.forEach(notifier -> notifier.notify("hello"));
  }
}
