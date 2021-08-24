package com.pavan.openweatherassignment.models.OpenWeather.conditions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Wind {
  @JsonProperty(value ="wind_speed")
  private double speed;
  @JsonProperty(value ="wind_deg")
  private int direction;
  @JsonProperty(value ="wind_gust")
  private double gust;

}