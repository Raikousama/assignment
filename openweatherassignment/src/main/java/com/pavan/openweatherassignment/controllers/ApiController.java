package com.pavan.openweatherassignment.controllers;

import com.pavan.openweatherassignment.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/")
public class ApiController {

  @Autowired
  private WeatherService weatherService;

  @GetMapping("/weather")
  public void getCurrentWeather(){
    weatherService.getCurrentWeather();
    Mono.just("Weather");
  }


  @GetMapping("/test")
  public void getForecast(){
    weatherService.getSevenDayForecast();
    Mono.just("Forecast");
  }
}
