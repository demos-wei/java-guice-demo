package com.example.guice.component.impl;

import com.example.guice.annotation.LogInvoke;
import com.example.guice.component.Notifier;

public class SmsNotifier implements Notifier {
  @Override
  @LogInvoke
  public void notify(String message) {
    System.out.printf("SMSð±  notify ð¢ð¢ð¢ %s \n", message);
  }
}
