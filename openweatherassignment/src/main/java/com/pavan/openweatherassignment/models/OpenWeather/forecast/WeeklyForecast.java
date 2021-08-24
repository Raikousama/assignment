package com.pavan.openweatherassignment.models.OpenWeather.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class WeeklyForecast {
  @Id
  private String id;
  @Indexed(unique=true)
  private String cityName;
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
