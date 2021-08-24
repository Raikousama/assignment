package com.pavan.openweatherassignment.repos;

import com.pavan.openweatherassignment.models.Cities;
import com.pavan.openweatherassignment.models.Users;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CityRepo extends ReactiveMongoRepository<Cities, String> {
  public Mono<Cities> findByCityName(String city);
}
