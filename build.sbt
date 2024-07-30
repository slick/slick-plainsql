import _root_.io.github.nafg.mergify.dsl._


mergifyExtraConditions := Seq(
  (Attr.Author :== "scala-steward") ||
    (Attr.Author :== "slick-scala-steward[bot]") ||
    (Attr.Author :== "renovate[bot]")
)
libraryDependencies ++= List(
  "org.slf4j" % "slf4j-nop" % "2.0.13",
  "com.h2database" % "h2" % "2.3.230"
)

scalacOptions += "-deprecation"

run / fork := true

libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value

Compile / unmanagedClasspath ++= (Compile / unmanagedResources).value
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.5.1"

githubWorkflowJavaVersions := JavaSpec.temurin("8") +: githubWorkflowJavaVersions.value

ThisBuild / githubWorkflowBuild := Seq(WorkflowStep.Sbt(List("runAll"), name = Some(s"Run all main classes")))

ThisBuild / githubWorkflowPublishTargetBranches := Seq()
