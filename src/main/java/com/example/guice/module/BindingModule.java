package com.example.guice.module;

import javax.inject.Provider;

import com.example.guice.annotation.AlipayTag;
import com.example.guice.annotation.DefaultPayTag;
import com.example.guice.annotation.LogInvoke;
import com.example.guice.annotation.WechatPayTag;
import com.example.guice.component.Advertiser;
import com.example.guice.component.Cooker;
import com.example.guice.component.Driver;
import com.example.guice.component.Notifier;
import com.example.guice.component.Packager;
import com.example.guice.component.Pay;
import com.example.guice.component.impl.AliPay;
import com.example.guice.component.impl.DefaultAdvertiser;
import com.example.guice.component.impl.DefaultCooker;
import com.example.guice.component.impl.DefaultDriver;
import com.example.guice.component.impl.DefaultNotifier;
import com.example.guice.component.impl.DefaultPackager;
import com.example.guice.component.impl.DefaultPay;
import com.example.guice.component.impl.SmsNotifier;
import com.example.guice.component.impl.WechatNotifier;
import com.example.guice.component.impl.WechatPay;
import com.example.guice.interceptor.InvokeLogger;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.matcher.Matchers;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.multibindings.ProvidesIntoSet;

public class BindingModule extends AbstractModule {

  @Override
  protected void configure() {

    // Linked Bindings
    bind(Cooker.class).to(DefaultCooker.class);

    // Instance Bindings
    bind(String.class).toInstance("material");


    // Binding Annotations
    bind(Pay.class).annotatedWith(DefaultPayTag.class).to(DefaultPay.class);
    bind(Pay.class).annotatedWith(AlipayTag.class).to(AliPay.class);

    // Provider Bindings
    bind(Advertiser.class).toProvider(AdvertiserProvider.class);

    // Untargeted Bindings
    bind(DefaultCooker.class);

    // Constructor Bindings
    try {
      bind(Driver.class).toConstructor(DefaultDriver.class.getConstructor());
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }

    // Multibindings
    Multibinder<Notifier> multibinder = Multibinder.newSetBinder(binder(), Notifier.class);
    multibinder.addBinding().to(DefaultNotifier.class);
    multibinder.addBinding().to(SmsNotifier.class);

    // aop
    InvokeLogger invokeLogger = new InvokeLogger();
    requestInjection(invokeLogger);
    bindInterceptor(Matchers.any(), Matchers.annotatedWith(LogInvoke.class), invokeLogger);
  }

  // Multibindings
  @ProvidesIntoSet
  public Notifier wechatNotifierProvide() {
    return new WechatNotifier();
  }

  @Provides
  @WechatPayTag
  public Pay wechatPayProvide() {
    return new WechatPay();
  }

  // @Provides method Bindings
  @Provides
  public Packager packagerProvide() {
    return new DefaultPackager("material");
  }

  public static class AdvertiserProvider implements Provider<Advertiser> {

    @Override
    public Advertiser get() {
      return new DefaultAdvertiser("slogan");
    }
  }
}
