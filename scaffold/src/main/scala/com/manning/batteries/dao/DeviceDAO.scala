package com.manning.batteries.dao

import org.jdbi.v3.sqlobject.customizer.{Bind, Define}
import org.jdbi.v3.sqlobject.statement.{SqlQuery, SqlUpdate}

/* imransarwar created on 02/11/2020*/
trait DeviceDAO {
  @SqlUpdate("create table <table> (id varchar(100) primary key, charging boolean)")
  def createTable(@Define table: String): Unit

  @SqlQuery("SELECT charging FROM <table> WHERE ID = :id")
  def isDeviceCharging(@Define("table") table: String, @Bind("id") id: String): Boolean

  @SqlUpdate("INSERT INTO <table> (id, charging) VALUES (:id, :charging)")
  def addDevice(@Define("table") table: String, @Bind("id") id: String, @Bind("charging") charging: Boolean): Unit
}
