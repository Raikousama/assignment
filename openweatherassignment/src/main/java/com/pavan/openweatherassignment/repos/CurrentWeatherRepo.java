package com.pavan.openweatherassignment.repos;

import com.pavan.openweatherassignment.models.OpenWeather.forecast.CurrentWeather;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CurrentWeatherRepo extends ReactiveMongoRepository<CurrentWeather,String> {
  public Mono<CurrentWeather> findByCityName(String cityName);
}
