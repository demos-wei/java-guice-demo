package com.example.guice;

import com.example.guice.annotation.AlipayTag;
import com.example.guice.annotation.DefaultPayTag;
import com.example.guice.annotation.WechatPayTag;
import com.example.guice.component.Advertiser;
import com.example.guice.component.Cooker;
import com.example.guice.component.Driver;
import com.example.guice.component.MultiBindWrapper;
import com.example.guice.component.Packager;
import com.example.guice.component.Pay;
import com.example.guice.component.impl.DefaultCooker;
import com.example.guice.component.impl.DefaultDriver;
import com.example.guice.component.impl.MeiTuanDriver;
import com.example.guice.entity.Order;
import com.example.guice.module.BindingModule;
import com.example.guice.servlet.SingletonScopeServlet;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main {

  public static void main(String[] args) throws Exception {
    System.out.println("================Linked Bindings=============");
    Injector injector = Guice.createInjector(new BindingModule());
    Cooker cooker = injector.getInstance(Cooker.class);
    cooker.cook("cake");

    System.out.println("================Instance Bindings=============");
    String material = injector.getInstance(String.class);
    System.out.println(material);

    System.out.println("================Provides method Bindings=============");
    Packager packager = injector.getInstance(Packager.class);
    packager.pack("cake");

    System.out.println("================Binding Annotations=============");
    Pay defaultPay = injector.getInstance(Key.get(Pay.class, DefaultPayTag.class));
    defaultPay.pay(new Order("cake", "address", 19d));

    Pay aliPay = injector.getInstance(Key.get(Pay.class, AlipayTag.class));
    aliPay.pay(new Order("cake", "address", 19d));

    Pay wechatPay = injector.getInstance(Key.get(Pay.class, WechatPayTag.class));
    wechatPay.pay(new Order("cake", "address", 19d));

    System.out.println("================Provider Bindings=============");
    Advertiser advertiser = injector.getInstance(Advertiser.class);
    advertiser.showSlogan();

    System.out.println("================Untargeted Bindings=============");
    DefaultCooker defaultCooker = injector.getInstance(DefaultCooker.class);
    defaultCooker.cook("default cake");

    System.out.println("================Constructor Bindings=============");
    Driver driver = injector.getInstance(DefaultDriver.class);
    driver.drive();

    System.out.println("================Just-in-time Bindings=============");
    Driver meiTuanDriver = injector.getInstance(MeiTuanDriver.class);
    meiTuanDriver.drive();

    System.out.println("================Multibindings=============");
    MultiBindWrapper wrapper = injector.getInstance(MultiBindWrapper.class);
    wrapper.doNotify();

    // scope demo
    System.out.println("================start scope demo server=============");
    Server server = new Server(8080);
    ServletContextHandler handler = new ServletContextHandler(
        server, "/", ServletContextHandler.SESSIONS
    );

    handler.addServlet(SingletonScopeServlet.class, "/scope/singleton");
    // TODO Add more scope.

    server.start();
  }
}
