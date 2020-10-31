package com.manning.batteries.resource

import com.codahale.metrics.annotation.Timed
import javax.ws.rs.core.MediaType.APPLICATION_JSON
import javax.ws.rs.core.Response
import javax.ws.rs.{GET, Path, Produces, QueryParam}

/* imransarwar created on 31/10/2020*/
@Path("/hello-world")
class HelloWorldResource(template: String, defaultName: String) {
  @Produces(Array(APPLICATION_JSON))
  @GET
  @Timed
  def sayHello: Response = Response.ok.entity(template.format(defaultName)).build()
}
