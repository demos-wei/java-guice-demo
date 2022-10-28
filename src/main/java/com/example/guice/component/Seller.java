package com.example.guice.component;

import com.example.guice.entity.Order;

public interface Seller {

   Order sell(String sellTarget, String address);

}
