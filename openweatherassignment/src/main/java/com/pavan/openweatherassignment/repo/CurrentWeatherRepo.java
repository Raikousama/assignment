package com.pavan.openweatherassignment.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CurrentWeatherRepo extends ReactiveMongoRepository<CurrentWeatherRepo,String> {

}
