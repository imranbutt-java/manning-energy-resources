package com.manning.batteries

import io.dropwizard.Configuration
import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.db.DataSourceFactory
import javax.validation.Valid
import javax.validation.constraints.NotNull
import org.hibernate.validator.constraints.NotEmpty

/* imransarwar created on 31/10/2020*/
class DeviceApiConfiguration extends Configuration {

  @Valid
  @NotNull
  @JsonProperty
  val database: DataSourceFactory = new DataSourceFactory()

  @JsonProperty("databaseName")
  val databaseName: String = null

  @JsonProperty("deviceTable")
  val deviceTable: String = null

  @NotEmpty
  @JsonProperty
  val template: String = ""

  @NotEmpty
  @JsonProperty
  val defaultName = "Stranger"
}