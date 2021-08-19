package com.pavan.openweatherassignment.model.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pavan.openweatherassignment.model.Temperature;
import com.pavan.openweatherassignment.model.Weather;
import com.pavan.openweatherassignment.model.conditions.FeelsLike;
import java.util.Date;

public class DailyForecast {
  @JsonProperty(value = "temp")
  private Temperature temperature;
  private Weather weather;
  @JsonProperty(value = "feels_like")
  private FeelsLike feelsLike;
  @JsonProperty(value = "dt")
  private Date date;
  private Date sunrise;
  private Date sunset;
  private Date moonrise;
  private Date moonset;
  @JsonProperty(value = "moon_phase")
  private Double moonPhase;
  private int pressure;
  private int humidity;
  @JsonProperty(value="dew_point")
  private double dewPoint;
  private int clouds;
  @JsonProperty(value = "uvi")
  private double uvIndex;
  private double pop;
  private double rain;
  private double snow;


  @JsonProperty(value = "wind_speed")
  private double windSpeed;
  @JsonProperty(value = "wind_degree")
  private double windDegree;
  @JsonProperty(value = "wind_gust")
  private double windGust;







}
