import _root_.io.github.nafg.mergify.dsl.*

ThisBuild / scalaVersion := "3.10.0"

mergifyExtraConditions := Seq(
  (Attr.Author :== "scala-steward") ||
    (Attr.Author :== "slick-scala-steward[bot]") ||
    (Attr.Author :== "renovate[bot]")
)
libraryDependencies ++= List(
  "org.slf4j"      % "slf4j-nop" % "2.0.20",
  "com.h2database" % "h2"        % "2.5.252"
)

scalacOptions += "-deprecation"

run / fork := true

libraryDependencies += "com.typesafe.slick" %% "slick" % "4.0.0-RC2"

ThisBuild / githubWorkflowJavaVersions          := Seq(JavaSpec.temurin("17"))
ThisBuild / githubWorkflowPublishTargetBranches := Seq()
ThisBuild / githubWorkflowBuild                 := Seq(
  WorkflowStep.Sbt(List("runAll"), name = Some(s"Run all main classes"))
)
