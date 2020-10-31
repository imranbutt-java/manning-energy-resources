package com.manning.batteries

import io.dropwizard.Application
import io.dropwizard.setup.{Bootstrap, Environment}

/* imransarwar created on 31/10/2020*/
object HelloWorldApplication extends Application[HelloWorldConfiguration] {
  def main(args: Array[String]): Unit = {
    run()
  }

  override def getName: String = "hello-world"
  override def initialize(bootstrap: Bootstrap[HelloWorldConfiguration]): Unit = {}
  override def run(t: HelloWorldConfiguration, environment: Environment): Unit = {
    val resource = new HelloWorldResource(t.template, t.defaultName)
    environment.jersey.register(resource)
  }
}
