val CatsVersion = "2.12.0"

libraryDependencies ++= Seq(
  "org.typelevel"              %% "cats-free"                 % CatsVersion,
  "org.typelevel"              %% "cats-laws"                 % CatsVersion % "test",
  "org.scalacheck"             %% "scalacheck"                % "1.19.0"    % "test",
  "com.github.alexarchambault" %% "scalacheck-shapeless_1.18" % "1.3.2"     % "test"
)

Compile / doc / scalacOptions := Seq("-groups", "-implicits")
