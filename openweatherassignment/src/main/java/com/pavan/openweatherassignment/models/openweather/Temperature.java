package com.pavan.openweatherassignment.models.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Temperature {
  @JsonProperty(value ="day")
  private double day;
  @JsonProperty(value ="min")
  private double min;
  @JsonProperty(value ="max")
  private double max;
  @JsonProperty(value ="night")
  private double night;
  @JsonProperty(value ="eve")
  private double evening;
  @JsonProperty(value ="morn")
  private double morning;
}