package com.pavan.openweatherassignment.models.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Coordinate {
  @JsonProperty(value = "lat")
  private double latitude;
  @JsonProperty(value = "lon")
  private double longitude;



}
