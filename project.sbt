
Global / organization := "io.verizon.quiver"

Global / scalaVersion := crossScalaVersions.value.head

//Global / crossScalaVersions := Seq("2.13.16", "2.12.4")
Global / crossScalaVersions := Seq("2.13.16")

scalacOptions in (Compile,doc) := Seq("-groups", "-implicits", "-nowarn", "--verbose")

lazy val quiver = project.in(file(".")).aggregate(core,codecs,docs)

lazy val core = project

lazy val docs = project.dependsOn(core, codecs)

lazy val codecs = project.dependsOn(core % "test->test;compile->compile")

//enablePlugins(DisablePublishingPlugin)
