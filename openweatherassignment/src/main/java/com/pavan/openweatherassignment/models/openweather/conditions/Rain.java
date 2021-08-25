package com.pavan.openweatherassignment.models.openweather.conditions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Rain {
  @JsonProperty(value ="1h")
  private double oneHour;

  /**
   * Rain volume for the last 3 hours
   */
  @JsonProperty(value ="3h")
  private double threeHours;
}
