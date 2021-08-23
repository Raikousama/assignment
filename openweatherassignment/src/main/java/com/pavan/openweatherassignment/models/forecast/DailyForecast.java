package com.pavan.openweatherassignment.models.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pavan.openweatherassignment.models.Temperature;
import com.pavan.openweatherassignment.models.Weather;
import com.pavan.openweatherassignment.models.conditions.FeelsLike;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class DailyForecast {
  @JsonProperty(value = "temp")
  private Temperature temperature;
  @JsonProperty(value = "weather")
  private List<Weather> weather;
  @JsonProperty(value = "feels_like")
  private FeelsLike feelsLike;
  @JsonProperty(value = "dt")
  private Date date;
  @JsonProperty(value = "sunrise")
  private Date sunrise;
  @JsonProperty(value = "sunset")
  private Date sunset;
  @JsonProperty(value = "moonrise")
  private Date moonRise;
  @JsonProperty(value = "moonset")
  private Date moonSet;
  @JsonProperty(value = "moon_phase")
  private Double moonPhase;
  @JsonProperty(value = "pressure")
  private int pressure;
  @JsonProperty(value = "humidity")
  private int humidity;
  @JsonProperty(value="dew_point")
  private double dewPoint;
  @JsonProperty(value = "clouds")
  private int clouds;
  @JsonProperty(value = "uvi")
  private double uvIndex;
  @JsonProperty(value = "pop")
  private double pop;
  @JsonProperty(value = "rain")
  private double rain;
  @JsonProperty(value = "snow")
  private double snow;
  @JsonProperty(value = "wind_speed")
  private double windSpeed;
  @JsonProperty(value = "wind_deg")
  private double windDegree;
  @JsonProperty(value = "wind_gust")
  private double windGust;







}
