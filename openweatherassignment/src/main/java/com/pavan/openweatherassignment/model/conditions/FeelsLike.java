package com.pavan.openweatherassignment.model.conditions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeelsLike {
  private double day;
  private double night;
  @JsonProperty(value ="eve")
  private double evening;
  @JsonProperty(value ="morn")
  private double morning;

}
