package com.pavan.openweatherassignment.repos;

import com.pavan.openweatherassignment.models.forecast.DailyForecast;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface WeatherRepo extends ReactiveMongoRepository<DailyForecast,String> {

}
