package com.example.guice.component.impl;

import com.example.guice.annotation.LogInvoke;
import com.example.guice.component.Pay;
import com.example.guice.entity.Order;

public class WechatPay implements Pay {
  @Override
  @LogInvoke
  public void pay(Order order) {
    System.out.printf("Wechat pay 💰💰💰 ¥%s for %s\n", order.getPrice(), order.getCake());
  }
}
