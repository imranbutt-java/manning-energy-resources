package com.manning.batteries

import com.codahale.metrics.annotation.Timed
import javax.ws.rs.{GET, Path, QueryParam}

/* imransarwar created on 31/10/2020*/
@Path("/hello-world")
//@Produces(MediaType.APPLICATION_JSON)
class HelloWorldResource(template: String, defaultName: String) {
  @GET
  @Timed
  def sayHello(@QueryParam("name") name: Option[String]): String = template.format(defaultName)
}
