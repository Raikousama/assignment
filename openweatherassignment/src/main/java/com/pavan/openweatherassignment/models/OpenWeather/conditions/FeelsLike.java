package com.pavan.openweatherassignment.models.OpenWeather.conditions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeelsLike {
  @JsonProperty(value ="day")
  private double day;
  @JsonProperty(value ="night")
  private double night;
  @JsonProperty(value ="eve")
  private double evening;
  @JsonProperty(value ="morn")
  private double morning;

}
