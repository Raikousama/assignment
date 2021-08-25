package com.pavan.openweatherassignment.models.openweather.conditions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentWind {
  @JsonProperty(value ="speed")
  private double speed;
  @JsonProperty(value ="deg")
  private int direction;
  @JsonProperty(value ="gust")
  private double gust;

}
