package com.pavan.openweatherassignment.model.conditions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Wind {
  @JsonProperty(value ="speed")
  private double speed;
  @JsonProperty(value ="deg")
  private int direction;
  @JsonProperty(value ="gust")
  private double gust;

}