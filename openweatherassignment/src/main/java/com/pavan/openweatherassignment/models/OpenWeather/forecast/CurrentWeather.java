package com.pavan.openweatherassignment.models.OpenWeather.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pavan.openweatherassignment.models.OpenWeather.Coordinate;
import com.pavan.openweatherassignment.models.OpenWeather.SystemParameters;
import com.pavan.openweatherassignment.models.OpenWeather.TempParameters;
import com.pavan.openweatherassignment.models.OpenWeather.Weather;
import com.pavan.openweatherassignment.models.OpenWeather.conditions.Clouds;
import com.pavan.openweatherassignment.models.OpenWeather.conditions.CurrentWind;
import com.pavan.openweatherassignment.models.OpenWeather.conditions.Rain;
import com.pavan.openweatherassignment.models.OpenWeather.conditions.Snow;
import com.pavan.openweatherassignment.models.OpenWeather.conditions.Wind;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

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
  private CurrentWind wind;
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

  @Indexed(unique=true)
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
