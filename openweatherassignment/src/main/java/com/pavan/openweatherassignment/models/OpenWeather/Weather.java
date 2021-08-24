package com.pavan.openweatherassignment.models.OpenWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {
    /**
     * Weather condition id
     */
    @JsonProperty(value ="id")
    private String id;
    /**
     * Group of weather parameters (Rain, Snow, Extreme etc.)
     */
    @JsonProperty(value ="main")
    private String main;
    /**
     * Weather condition within the group
     */
    @JsonProperty(value ="description")
    private String description;
    /**
     * Weather icon id
     */
    @JsonProperty(value ="icon")
    private String icon;
  }