package com.pavan.openweatherassignment.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pavan.openweatherassignment.models.forecast.CurrentWeather;
import com.pavan.openweatherassignment.models.forecast.WeeklyForecast;
import java.time.Duration;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class FetchWeatherData {
  @Value("${weather.api.id}")
  private String apiId;

  WebClient webClient = WebClient.create("https://api.openweathermap.org/data/2.5/");
//TODO Change City

  public void refreshForecastData(String city){
    Instant end = Instant.now();
    Duration timeElapsed = Duration.between(end, end);
    if (timeElapsed.toDays() >= 1) {
//      getForecastData();
    }
  }

  public void getForecastData(String longi, String lati){
    webClient.get().uri("/onecall?lat="+ lati+ "&lon="+longi+"&exclude=hourly,current,minutely&appid="+apiId).retrieve().bodyToMono(String.class).subscribe(v ->{
      ObjectMapper mapper = new ObjectMapper();
      try {
        WeeklyForecast cw = mapper.readValue(v, WeeklyForecast.class);
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }

    });
  }

  public void getCurrentWeatherData(String city){
    webClient.get().uri("weather?q="+ city +"&appid="+apiId).retrieve().bodyToMono(String.class).subscribe(v ->{
      ObjectMapper mapper = new ObjectMapper();
      try {
        CurrentWeather cw = mapper.readValue(v, CurrentWeather.class);
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }

    });
  }

}
