package com.example.guice.component.impl;

import com.example.guice.annotation.LogInvoke;
import com.example.guice.component.Advertiser;

public class DefaultAdvertiser implements Advertiser {

  private final String slogan;

  public DefaultAdvertiser(String slogan) {
    this.slogan = slogan;
    try {
      System.out.println("🔊🔊 start init advertiser 🔊🔊");
      int count = 0;
      while (count < 5) {
        count++;
        System.out.printf("init advertiser %s ...\n", count);
        Thread.sleep(1000);
      }
      System.out.println("🔊🔊 end init advertiser 🔊🔊");
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  @LogInvoke
  public void showSlogan() {
    System.out.println(slogan);
  }

}
