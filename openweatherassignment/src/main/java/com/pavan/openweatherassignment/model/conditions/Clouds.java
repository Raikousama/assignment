
package com.pavan.openweatherassignment.model.conditions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Clouds {
  /**
   * Cloudiness, %
   */
  @JsonProperty(value ="all")
  private double all;
}
