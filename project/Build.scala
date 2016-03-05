import sbt._
import sbt.Keys._


object TFArtifactsBuild extends Build {

   val org = "org.tensorframes"
   val namePrefix = "javacpp"
   val v = "0.0.1-1.2SNAP"

   val commonSettings = Seq(
         organization := org,
         version := v,
         publishArtifact in packageDoc := false,
         publishArtifact in packageSrc := false,
         exportJars := true,
         crossPaths := false
      )

   lazy val main = Project(
        id = "main",
        base = file("."),
        settings = Seq(
         name := namePrefix + "-artifacts") ++ commonSettings
      ).dependsOn(javacpp, tensorflow, tensorflowLinuxXX)

   lazy val javacpp = Project(
        id = "javacpp",
        base = file("javacpp")
      ).settings(
      name := namePrefix + "-javacpp",
      packageBin in Compile := baseDirectory.value / "javacpp.jar")
      .settings(commonSettings: _*)

   lazy val tensorflow = Project(
        id = "tensorflow",
        base = file("tensorflow")
      ).settings(
      name := namePrefix + "-tensorflow",
      packageBin in Compile := baseDirectory.value / "tensorflow.jar")
      .settings(commonSettings: _*)

   lazy val tensorflowLinuxXX = Project(
        id = "tensorflowLinuxXX",
        base = file("tensorflow-linux-x86_64")
      ).settings(
      name := namePrefix + "-tensorflow-linux-x86_64",
      packageBin in Compile := baseDirectory.value / "tensorflow-linux-x86_64.jar")
      .settings(commonSettings: _*)

    
}
