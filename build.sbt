import _root_.io.github.nafg.mergify.dsl.*

inThisBuild(
  List(
    scalaVersion := "2.13.15",
    scalacOptions += "-Xsource:3"
  )
)

mergifyExtraConditions := Seq(
  (Attr.Author :== "scala-steward") ||
    (Attr.Author :== "slick-scala-steward[bot]") ||
    (Attr.Author :== "renovate[bot]")
)
libraryDependencies ++= List(
  "org.slf4j"      % "slf4j-nop" % "2.0.17",
  "com.h2database" % "h2"        % "2.4.240"
)

scalacOptions += "-deprecation"

run / fork := true

libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value

Compile / unmanagedClasspath ++= (Compile / unmanagedResources).value
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.6.0"

ThisBuild / githubWorkflowJavaVersions          := Seq(JavaSpec.temurin("11"))
ThisBuild / githubWorkflowPublishTargetBranches := Seq()
ThisBuild / githubWorkflowBuild                 := Seq(
  WorkflowStep.Sbt(List("runAll"), name = Some(s"Run all main classes"))
)
