package com.pavan.openweatherassignment.model.forecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pavan.openweatherassignment.model.Coordinate;
import com.pavan.openweatherassignment.model.SystemParameters;
import com.pavan.openweatherassignment.model.TempParameters;
import com.pavan.openweatherassignment.model.Weather;
import com.pavan.openweatherassignment.model.conditions.Clouds;
import com.pavan.openweatherassignment.model.conditions.Rain;
import com.pavan.openweatherassignment.model.conditions.Snow;
import com.pavan.openweatherassignment.model.conditions.Wind;
import java.util.Date;

public class CurrentWeather {

  private Coordinate coordinate;
  private Weather weather;
  private String base;

  @JsonProperty(value = "main")
  private TempParameters tempparameters;

  private Wind wind;
  private Clouds clouds;
  private Rain rain;
  private Snow snow;

  @JsonProperty(value = "dt")
  private Date date;

  @JsonProperty(value ="sys")
  private SystemParameters systemParameters;

  @JsonProperty(value = "name")
  private String cityName;

  @JsonProperty(value ="id")
  private long cityId;

  private String cod;

  private int visibility;

  private double timezone;


}
