libraryDependencies ++= List(
  "org.slf4j" % "slf4j-nop" % "1.7.36",
  "com.h2database" % "h2" % "2.1.214"
)

scalacOptions += "-deprecation"

run / fork := true

libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value

Compile / unmanagedClasspath ++= (Compile / unmanagedResources).value
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.4.0-RC2"
