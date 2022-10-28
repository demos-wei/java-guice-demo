package com.example.guice.servlet;

import java.io.IOException;

import com.example.guice.component.Scope;
import com.example.guice.component.impl.SingletonScope;
import com.example.guice.module.ScopeModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SingletonScopeServlet extends HttpServlet {
  private final Injector injector = Guice.createInjector(new ScopeModule());

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Scope scope = injector.getInstance(SingletonScope.class);

    resp.getWriter().printf("scopeTest Id: %s", scope.getId());
  }
}
