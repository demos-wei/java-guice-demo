# Java Guice inject demo
A demo Guice inject, this demo includes all the bindings, and integrate a jetty server to test singleton scope.


Build the application by running:
```shell
$ bazel build //:guice-demo
$ bazel-bin/guice-demo
#(print logs)
```

Once the jetty server is running, visit `http://localhost:8080/scope/singleton` to test singleton scope.
