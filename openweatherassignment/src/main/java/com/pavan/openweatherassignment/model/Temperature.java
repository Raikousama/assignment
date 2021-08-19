package com.pavan.openweatherassignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Temperature {
  private double day;
  private double min;
  private double max;
  private double night;
  @JsonProperty(value ="eve")
  private double evening;
  @JsonProperty(value ="morn")
  private double morning;
}