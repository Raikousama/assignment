package com.pavan.openweatherassignment.model.conditions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Snow {

  @JsonProperty(value ="1h")
  private double oneHour;

  /**
   * Snow volume for the last 3 hours
   */
  @JsonProperty(value ="3h")
  private double threeHours;
}
