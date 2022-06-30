name := """SimpleScalaPlay"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.8"

resolvers += "Sonatype OSS Release Repository" at "https://oss.sonatype.org/content/repositories/releases/"

val versionJWK = "1.2.24"

//for all "import play.api.libs.json"(json parsing):
libraryDependencies += guice
//for all play dependencies, in this case I think is "import play.api.mvc._"(this is spring framework like for scala):
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

