package com.pavan.openweatherassignment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pavan.openweatherassignment.models.openweather.forecast.DailyForecast;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherForecastDto {
  @JsonProperty(value = "city")
  private String cityName;
  @JsonProperty(value = "lat")
  private double latitude;
  @JsonProperty(value = "lon")
  private double longitude;
  @JsonProperty(value = "timezone")
  private String timezone;
  @JsonProperty(value = "timezone_offset")
  private double timezoneOffset;
  @JsonProperty(value = "daily_forecast")
  private List<DailyForecast> dailyForecast;

}
