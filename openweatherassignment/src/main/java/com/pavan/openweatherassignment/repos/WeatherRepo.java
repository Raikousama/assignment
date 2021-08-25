package com.pavan.openweatherassignment.repos;

import com.pavan.openweatherassignment.models.openweather.forecast.WeeklyForecast;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface WeatherRepo extends ReactiveMongoRepository<WeeklyForecast,String> {
  Mono<WeeklyForecast> findByCityName(String cityName);
}
