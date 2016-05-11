lazy val commonSettings = Seq(

  scalaVersion := "2.10.4",
  organization := "com.h7d1w0",
  version := "0.1.0",
  name := "CodeExample"
)

// define ModuleID for library dependencies
//lazy val scalacheck = "org.scalacheck" %% "scalacheck" % "1.12.0"

// define ModuleID using string interpolator
//lazy val osmlibVersion = "2.5.2-RC1"
//lazy val osmlib = ("net.sf.travelingsales" % "osmlib" % osmlibVersion from
//  s"""http://downloads.sourceforge.net/project/travelingsales/libosm/$osmlibVersion/libosm-$osmlibVersion.jar""")

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(

    libraryDependencies ++= Seq(
    
        "com.amazonaws" % "aws-java-sdk" % "1.10.22" intransitive(),
        "com.amazonaws" % "aws-java-sdk-core" % "1.10.22" intransitive(),
        "com.amazonaws" % "amazon-kinesis-client" % "1.6.1" ,
        "org.apache.httpcomponents" % "httpclient" % "4.3.6" intransitive(),
        "org.apache.httpcomponents" % "httpcore" % "4.3.3" intransitive(),
        
        "org.apache.spark" % "spark-core_2.10" % "1.5.1" ,
        "org.apache.spark" % "spark-streaming_2.10" % "1.5.1" ,
        
        "org.scalatest" % "scalatest_2.10" % "2.0" % "test" intransitive(),

        "org.apache.hadoop" % "hadoop-client" % "2.6.0" intransitive(),

        "com.datastax.cassandra" % "cassandra-driver-core" % "2.1.8" intransitive()
    ),

    // Exclude transitive dependencies, e.g., include log4j without including logging via jdmk, jmx, or jms.
    libraryDependencies +=
      "log4j" % "log4j" % "1.2.15" intransitive() excludeAll(
        ExclusionRule(organization = "com.sun.jdmk"),
        ExclusionRule(organization = "com.sun.jmx"),
        ExclusionRule(organization = "javax.jms")
      )
  )
