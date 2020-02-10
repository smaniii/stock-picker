name := """stock-picker"""
organization := "com.seth"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)


scalaVersion := "2.13.1"

libraryDependencies += guice
libraryDependencies += ws
libraryDependencies += "org.webjars" % "flot" % "0.8.3-1"
libraryDependencies += "org.webjars" % "bootstrap" % "3.3.7"
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.6"
libraryDependencies += "com.yahoofinance-api" % "YahooFinanceAPI" % "3.15.0"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
