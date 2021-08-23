package com.pavan.openweatherassignment.repo;

import com.pavan.openweatherassignment.model.forecast.DailyForecast;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface WeatherRepo extends ReactiveMongoRepository<DailyForecast,String> {

}
