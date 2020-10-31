package com.manning.batteries

import com.manning.batteries.resource.HelloWorldResource
import io.dropwizard.Application
import io.dropwizard.setup.{Bootstrap, Environment}

/* imransarwar created on 31/10/2020*/
class HelloWorldApplication extends Application[HelloWorldConfiguration] {
  override def getName: String = "hello-world"
  override def initialize(bootstrap: Bootstrap[HelloWorldConfiguration]): Unit = {}

  override def run(t: HelloWorldConfiguration, environment: Environment): Unit = {
    val resource = new HelloWorldResource(t.template, t.defaultName)
    environment.jersey.register(resource)
  }
}

object HelloWorldApplication {
  def main(args: Array[String]): Unit = {
    new HelloWorldApplication().run(args: _*)
  }
}
