
lazy val client = (project in file("client"))
  .settings(
    scalaVersion := "2.13.3",
    scalaJSUseMainModuleInitializer := true,
    scalafmtOnCompile := true,
    libraryDependencies ++= Seq(
      "ba.sake" %%% "rxtags" % "0.0.3"
    )
  )
  .enablePlugins(ScalaJSPlugin)
