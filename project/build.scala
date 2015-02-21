import sbt._
import Keys._

object Build extends Build {

  lazy val buildSettings = Seq(
    libraryDependencies ++= Seq(
      "org.scodec" %% "scodec-core" % "1.7.0",
      "org.specs2" %% "specs2" % "2.4.15" % "test",
      "org.scalacheck" %% "scalacheck" % "1.12.2" % "test"
    )
  ) ++ Seq(
    scalaVersion := "2.11.5",
    crossScalaVersions := Seq("2.10.4", scalaVersion.value),
    resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases",
    scalacOptions ++= (
      "-deprecation" ::
        "-unchecked" ::
        "-Xlint" ::
        "-language:existentials" ::
        "-language:higherKinds" ::
        "-language:implicitConversions" ::
        Nil
      ),
    scalacOptions ++= {
      if (scalaVersion.value.startsWith("2.11"))
        Seq("-Ywarn-unused", "-Ywarn-unused-import")
      else
        Nil
    },
    pomExtra :=
      <developers>
        <developer>
          <id>filippovitale</id>
          <name>Filippo Vitale</name>
          <url>https://github.com/filippovitale</url>
        </developer>
      </developers>
        <scm>
          <url>git@github.com:filippovitale/pefile.git</url>
          <connection>scm:git:git@github.com:filippovitale/pefile.git</connection>
          <tag>
            {scala.util.Try(sys.process.Process("git rev-parse HEAD").lines_!.head).getOrElse("no-tag")}
          </tag>
        </scm>
    ,
    description := "yet another pe analyser",
    organization := "com.github.filippovitale",
    homepage := Some(url("https://github.com/filippovitale/pefile")),
    licenses := Seq("MIT" -> url("http://www.opensource.org/licenses/mit-license.php"))
  ) ++ bintray.Plugin.bintraySettings

  lazy val pefile = Project(
    id = "pefile",
    base = file("."),
    settings = buildSettings
  )
}
