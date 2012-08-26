
name := "limitDbColumn"

version := "0.1.0"

organization := "eureka.inf.br"
 
scalaVersion := "2.9.1"

scalacOptions ++= DefaultOptions.scalac

scalacOptions in Compile += Opts.compile.deprecation

scalacOptions in Compile += Opts.compile.unchecked
 
seq(webSettings: _*)

resolvers ++= Seq(
  "Java.net Maven2 Repo" at "http://download.java.net/maven/2/",
  "Sonatype OSS Snapshot Repository" at "https://oss.sonatype.org/content/repositories/releases/",
  "Maven Central" at "http://repo1.maven.org/maven2"
)

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.0.0")

libraryDependencies ++= {
  val liftVersion = "2.4"
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default" withSources(),
    "net.liftweb" %% "lift-wizard" % liftVersion % "compile->default" withSources(),
    "net.liftweb" %% "lift-json-ext" % liftVersion % "compile->default" withSources(),
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default" withSources()
  )
}
  
libraryDependencies ++= Seq(
    "javax.servlet"         % "servlet-api"        % "2.5"              % "provided->default",
    "org.specs2"            % "specs2_2.9.2"       % "1.9"              % "test->default",
    "org.eclipse.jetty"     % "jetty-webapp"       % "8.0.4.v20111024"  % "container",
    "org.eclipse.jetty"     % "jetty-plus"         % "8.0.4.v20111024"  % "container"
)
