package com.pavan.openweatherassignment.services;

import com.pavan.openweatherassignment.dto.WeatherDto;
import com.pavan.openweatherassignment.models.OpenWeather.forecast.CurrentWeather;
import com.pavan.openweatherassignment.models.OpenWeather.forecast.WeeklyForecast;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface WeatherService {
  Flux<WeeklyForecast> findAll();
  Mono<CurrentWeather> createWeatherDetails(Mono<CurrentWeather> weatherDto);

  Mono<WeeklyForecast> createForecastDetails(Mono<WeeklyForecast> weatherDto);

  Mono<WeeklyForecast> updateForecastDetails(String id, Mono<WeeklyForecast> weatherDto);

  Mono<CurrentWeather> updateWeatherDetails(String id,Mono<CurrentWeather> weatherDto);
  Mono<CurrentWeather> getWeatherDetailsByCity (String city);
  Mono<Void> deleteWeatherDetailsById(String id);

  Mono<WeeklyForecast> getForecastDetailsByCity(String city);

  Mono<Void> deleteForecastDetailsById(String id);
}
