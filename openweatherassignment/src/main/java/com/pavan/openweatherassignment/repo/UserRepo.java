package com.pavan.openweatherassignment.repo;

import com.pavan.openweatherassignment.model.Users;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepo extends ReactiveMongoRepository<Users,String> {

}
