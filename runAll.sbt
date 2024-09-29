// based on https://stackoverflow.com/a/63780833/333643
lazy val runAll = taskKey[Unit]("Run all main classes")

def runAllIn(config: Configuration) = Def.task {
  val s       = streams.value
  val cp      = (config / fullClasspath).value
  val r       = (config / run / runner).value
  val classes = (config / discoveredMainClasses).value
  classes.foreach { className =>
    r.run(className, cp.files, Seq(), s.log).get
  }
}

runAll := {
  runAllIn(Compile).value
  runAllIn(Test).value
}
