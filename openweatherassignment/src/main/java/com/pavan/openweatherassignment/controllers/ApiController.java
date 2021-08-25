package com.pavan.openweatherassignment.controllers;

import com.pavan.openweatherassignment.dto.CurrentWeatherDto;
import com.pavan.openweatherassignment.dto.WeatherForecastDto;
import com.pavan.openweatherassignment.models.openweather.forecast.CurrentWeather;
import com.pavan.openweatherassignment.models.openweather.forecast.WeeklyForecast;
import com.pavan.openweatherassignment.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/weather")
public class ApiController {

  @Autowired
  private WeatherService weatherService;


  @GetMapping("/{city}")
  public Mono<CurrentWeatherDto> getWeatherDetailsByCity(@PathVariable String city) {
    return weatherService.getWeatherDetailsByCity(city);
  }

  @GetMapping("/forecasts/{city}")
  public Mono<WeatherForecastDto> getForecastDetailsByCity(@PathVariable String city) {
    return weatherService.getForecastDetailsByCity(city);
  }
}
