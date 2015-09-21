# A Simple Statistics Library

Build-setup inspired by:

- [Scala.js documentation](http://www.scala-js.org/doc/sbt/cross-building.html)
- [Scala.js cross compile example](https://github.com/scala-js/scalajs-cross-compile-example)

## Run tests

Simply run `sbt test`.

To run tests just on one platform, launch sbt and type one of the following:

  sbt> libraryJS/test
  sbt> libraryJVM/test

For a test run with logs run `sbt test > test.log`.


## IntelliJ

IntelliJ does not support referencing to the shared directory. But this is just the IDE. The compiler understands the shared code. So it works as it is supposed to.
