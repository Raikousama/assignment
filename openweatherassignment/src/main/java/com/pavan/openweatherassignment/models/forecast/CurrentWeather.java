package com.pavan.openweatherassignment.models.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pavan.openweatherassignment.models.Coordinate;
import com.pavan.openweatherassignment.models.SystemParameters;
import com.pavan.openweatherassignment.models.TempParameters;
import com.pavan.openweatherassignment.models.Weather;
import com.pavan.openweatherassignment.models.conditions.Clouds;
import com.pavan.openweatherassignment.models.conditions.Rain;
import com.pavan.openweatherassignment.models.conditions.Snow;
import com.pavan.openweatherassignment.models.conditions.Wind;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class CurrentWeather {
  @JsonProperty(value = "coord")
  private Coordinate coordinate;
  @JsonProperty(value = "weather")
  private List<Weather> weather;
  @JsonProperty(value = "base")
  private String base;

  @JsonProperty(value = "main")
  private TempParameters tempparameters;
  @JsonProperty(value = "wind")
  private Wind wind;
  @JsonProperty(value = "clouds")
  private Clouds clouds;
  @JsonProperty(value = "rain")
  private Rain rain;
  @JsonProperty(value = "snow")
  private Snow snow;

  @JsonProperty(value = "dt")
  private Date date;

  @JsonProperty(value ="sys")
  private SystemParameters systemParameters;

  @JsonProperty(value = "name")
  private String cityName;

  @JsonProperty(value ="id")
  private long cityId;

  @JsonProperty(value = "cod")
  private int cod;

  @JsonProperty(value = "visibility")
  private int visibility;
  @JsonProperty(value = "timezone")
  private double timezone;


}
