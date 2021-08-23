package com.pavan.openweatherassignment.repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CurrentWeatherRepo extends ReactiveMongoRepository<CurrentWeatherRepo,String> {

}
