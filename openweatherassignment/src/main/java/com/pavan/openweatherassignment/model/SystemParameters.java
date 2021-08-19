package com.pavan.openweatherassignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Data;

@Data
public class SystemParameters {
  @JsonProperty(value ="type")
  private String type;
  @JsonProperty(value ="id")
  private String id;
  @JsonProperty(value ="message")
  private String message;
  @JsonProperty(value ="country")
  private String country;
//  @JsonAdapter(SecondsDateTypeAdapter.class)
  @JsonProperty(value ="sunrise")
  private Date sunrise;
//  @JsonAdapter(SecondsDateTypeAdapter.class)
  @JsonProperty(value ="sunset")
  private Date sunset;
}