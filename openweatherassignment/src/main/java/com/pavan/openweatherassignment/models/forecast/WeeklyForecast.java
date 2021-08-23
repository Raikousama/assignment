package com.pavan.openweatherassignment.models.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class WeeklyForecast {
  @JsonProperty(value = "lat")
  private double latitude;
  @JsonProperty(value = "lon")
  private double longitude;
  @JsonProperty(value = "timezone")
  private String timezone;
  @JsonProperty(value = "timezone_offset")
  private double timezoneOffset;
  @JsonProperty(value = "daily")
  private List<DailyForecast> dailyForecast;


}
