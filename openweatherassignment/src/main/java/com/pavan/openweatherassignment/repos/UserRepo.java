package com.pavan.openweatherassignment.repos;

import com.pavan.openweatherassignment.models.Users;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepo extends ReactiveMongoRepository<Users,String> {
  public Mono<Users> findByUserName(String userName);
}
