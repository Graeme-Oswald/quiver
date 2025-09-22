Global / organization := "io.verizon.quiver"

Global / scalaVersion := crossScalaVersions.value.head

Global / crossScalaVersions := Seq("2.13.16", "2.12.20")

lazy val publishSettings = Seq(
  credentials += Credentials("Sonatype Nexus Repository Manager", "nexus-proxy.lighthouse.jhc.uk", "dev", "jhcjhc"),

  publishTo := {
    val nexus = "https://nexus-proxy.lighthouse.jhc.uk/nexus/content/repositories/"

    if (isSnapshot.value)
      Some("snapshots" at nexus + "snapshots")
    else
      Some("releases" at nexus + "releases")
  }
)

scalacOptions in (Compile,doc) := Seq("-groups", "-implicits")

lazy val quiver = project.in(file("."))
  .aggregate(core,codecs,docs)
  .settings(publishSettings: _*)

lazy val core = project.settings(publishSettings: _*)

lazy val docs = project.dependsOn(core, codecs).settings(publishSettings: _*)

lazy val codecs = project.dependsOn(core % "test->test;compile->compile").settings(publishSettings: _*)

//enablePlugins(DisablePublishingPlugin)
