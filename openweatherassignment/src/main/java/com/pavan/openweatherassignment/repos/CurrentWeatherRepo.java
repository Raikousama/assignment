package com.pavan.openweatherassignment.repos;

import com.pavan.openweatherassignment.models.openweather.forecast.CurrentWeather;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CurrentWeatherRepo extends ReactiveMongoRepository<CurrentWeather,String> {
  Mono<CurrentWeather> findByCityName(String cityName);
}
