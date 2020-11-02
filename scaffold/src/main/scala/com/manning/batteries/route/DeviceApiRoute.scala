package com.manning.batteries.route

import com.manning.batteries.DeviceApiServer
import com.manning.batteries.dao.DeviceDAO
import javax.ws.rs.core.Response
import javax.ws.rs.{GET, Path, QueryParam}
import org.slf4j.LoggerFactory

/* imransarwar created on 02/11/2020*/
@Path("/")
class DeviceApiRoute(db: DeviceDAO, table: String) {
  val logger = LoggerFactory.getLogger(classOf[DeviceApiServer])

  @GET
  @Path("/status")
  def getStatus(@QueryParam("id") id: String): Response = {
    logger.info(s"table: $table, id: $id")
    Response.ok.entity(db.isDeviceCharging(table, id)).build()
  }
}
