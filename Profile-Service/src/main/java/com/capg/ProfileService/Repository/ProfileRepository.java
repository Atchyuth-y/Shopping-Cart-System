package com.capg.ProfileService.Repository;

import com.capg.ProfileService.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProfileRepository extends MongoRepository<User, Integer> {
}
