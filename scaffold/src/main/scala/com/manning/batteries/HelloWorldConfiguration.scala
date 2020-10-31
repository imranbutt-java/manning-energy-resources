package com.manning.batteries

import io.dropwizard.Configuration
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.NotEmpty

/* imransarwar created on 31/10/2020*/
class HelloWorldConfiguration extends Configuration {
  @NotEmpty
  @JsonProperty
  val template: String = ""

  @NotEmpty
  @JsonProperty
  val defaultName = "Stranger"
}