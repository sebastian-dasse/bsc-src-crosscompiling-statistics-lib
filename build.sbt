enablePlugins(ScalaJSPlugin)            // Turn this project into a Scala.js project by importing these settings

name := "statistics-lib"

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .aggregate(libJS, libJVM)
  .settings(
    publish := {},
    publishLocal := {}
  )

lazy val library = crossProject
  .in(file("./library"))
  .settings(
    name := "Lib",
    version := "1.0",
    scalaVersion := "2.11.7",
    scalacOptions ++= Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-feature",
      "-unchecked",
      "-Xfatal-warnings",
      "-Xlint"
    ),
    libraryDependencies ++= Seq(
      "com.lihaoyi" %%% "utest" % "0.3.1" % "test"
    ),
    testFrameworks += new TestFramework("utest.runner.Framework")
  ).jsSettings(
    name := "libJS",
    scalaJSStage in Global := FastOptStage, // to use Node.js or PhantomJS for tests
    jsDependencies in Test += RuntimeDOM    // to use PhantomJS for tests
  ).jvmSettings(
    name := "libJVM"
    // JVM-specific settings here
  )

lazy val libJS = library.js
lazy val libJVM = library.jvm
