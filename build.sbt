libraryDependencies ++= List(
  "org.slf4j" % "slf4j-nop" % "2.0.0",
  "com.h2database" % "h2" % "2.1.214"
)

scalacOptions += "-deprecation"

run / fork := true

libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value

Compile / unmanagedClasspath ++= (Compile / unmanagedResources).value
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.4.0"

githubWorkflowJavaVersions := JavaSpec.temurin("8") +: githubWorkflowJavaVersions.value

ThisBuild / githubWorkflowBuild := Seq(WorkflowStep.Sbt(List("runAll"), name = Some(s"Run all main classes")))
