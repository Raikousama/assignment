package com.pavan.openweatherassignment.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TempParameters {

    @JsonProperty(value ="temp")
    private double temperature;
    @JsonProperty(value ="feels_like")
    private double feelsLike;
    @JsonProperty(value ="pressure")
    private double pressure;
    @JsonProperty(value ="humidity")
    private double humidity;
    @JsonProperty(value ="temp_min")
    private double minimumTemperature;
    @JsonProperty(value ="temp_max")
    private double maximumTemperature;
    @JsonProperty(value ="sea_level")
    private double seaLevelPressure;
    @JsonProperty(value ="grnd_level")
    private double groundLevelPressure;

}
