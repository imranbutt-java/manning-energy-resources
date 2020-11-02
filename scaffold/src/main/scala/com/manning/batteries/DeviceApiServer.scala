package com.manning.batteries

import com.codahale.metrics.MetricRegistry
import com.manning.batteries.dao.DeviceDAO
import com.manning.batteries.resource.DeviceApiResource
import com.manning.batteries.route.DeviceApiRoute
import io.dropwizard.Application
import io.dropwizard.jdbi3.JdbiFactory
import io.dropwizard.setup.{Bootstrap, Environment}
import org.apache.kafka.common.metrics.JmxReporter
import org.jdbi.v3.core.Jdbi

/* imransarwar created on 31/10/2020*/
class DeviceApiServer extends Application[DeviceApiConfiguration] {
  override def getName: String = "hello-world"
  override def initialize(bootstrap: Bootstrap[DeviceApiConfiguration]): Unit = {}

  override def run(config: DeviceApiConfiguration, environment: Environment): Unit = {
    // val resource = new DeviceApiResource(config.template, config.defaultName)
    // environment.jersey.register(resource)

    val factory: JdbiFactory = new JdbiFactory()
    val jdbi: Jdbi = factory.build(environment, config.database, config.databaseName)
    val dbDao = jdbi.onDemand(classOf[DeviceDAO])
//    dbDao.createTable(config.deviceTable)

    environment.jersey.register(new DeviceApiRoute(dbDao, config.deviceTable))
    environment.jersey.setUrlPattern("/api")
  }
}

object DeviceApiServer {
  def main(args: Array[String]): Unit = {
    new DeviceApiServer().run(args: _*)
  }
}
