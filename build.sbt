organization:= "com.drillinginfo.global"

name := "di-metrics"

version := "0.1"

val metricsVersion = "3.0.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.kenshoo" %% "metrics-play" % "0.1.3",
  "com.codahale.metrics" % "metrics-core" % metricsVersion,
  "com.codahale.metrics" % "metrics-healthchecks" % metricsVersion
)     

publishMavenStyle := true

pomIncludeRepository := { _ => false }

publishArtifact in Test := false

pomExtra := (
  <url>https://git.drillinginfo.com/diglobal/di-metrics</url>
  <inceptionYear>2014</inceptionYear>
  <scm>
    <url>git@git.drillinginfo.com:kenshoDIGlobal/di-metrics.git</url>
    <connection>scm:git@git.drillinginfo.com:kenshoDIGlobal/di-metrics.git</connection>
  </scm>
  <developers>
    <developer>
      <name>Ron Romero</name>
      <email>ron.romero@drillinginfo.com</email>
      <roles>
        <role>Author</role>
      </roles>
      <organization>Drillinginfo</organization>
    </developer>
  </developers>)
