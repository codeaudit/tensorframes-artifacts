// Your sbt build file. Guides on how to write one can be found at
// http://www.scala-sbt.org/0.13/docs/index.html

scalaVersion := "2.11.7"

licenses := Seq("Apache-2.0" -> url("http://opensource.org/licenses/Apache-2.0"))

addCommandAlias("goLocal", ";publishLocal;javacpp/publishLocal;tensorflow/publishLocal;tensorflowLinuxXX/publishLocal")
