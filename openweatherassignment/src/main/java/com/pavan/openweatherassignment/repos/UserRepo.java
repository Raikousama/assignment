package com.pavan.openweatherassignment.repos;

import com.pavan.openweatherassignment.models.Users;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepo extends ReactiveMongoRepository<Users,String> {

}
