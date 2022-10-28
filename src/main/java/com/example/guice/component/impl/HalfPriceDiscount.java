package com.example.guice.component.impl;

import com.example.guice.annotation.LogInvoke;
import com.example.guice.component.Discount;

public class HalfPriceDiscount implements Discount {
  @Override
  @LogInvoke
  public Double discount(Double price) {
    return price * 0.5;
  }
}
