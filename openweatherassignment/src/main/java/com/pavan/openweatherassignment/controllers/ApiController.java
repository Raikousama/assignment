package com.pavan.openweatherassignment.controllers;

import com.pavan.openweatherassignment.dto.WeatherDto;
import com.pavan.openweatherassignment.models.OpenWeather.forecast.CurrentWeather;
import com.pavan.openweatherassignment.models.OpenWeather.forecast.WeeklyForecast;
import com.pavan.openweatherassignment.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/")
public class ApiController {

  @Autowired
  private WeatherService weatherService;
//
//  @GetMapping("weather/{city}")
//  public Mono<WeeklyForecast> getCurrentWeather(@PathVariable  String city) {
//    return weatherService.createWeatherDetails(city);
//  }


  @GetMapping("Forecast/{city}")
  public Mono<ResponseEntity<WeeklyForecast>> getForecast(@PathVariable String id, @RequestBody Mono<WeeklyForecast> weatherDto) {

    return weatherService.updateForecastDetails(id, weatherDto)
        .map(updatedItem -> new ResponseEntity<>(updatedItem, HttpStatus.OK))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/city/{city}")
  public Mono<CurrentWeather> getWeatherDetailsByCity(@PathVariable String city) {
//    log.info("Inside Class WeatherController Method getWeatherDetailsByCity");
    return weatherService.getWeatherDetailsByCity(city);
  }
}
