package com.example.Heritage.Ai.Repository;

import com.example.Heritage.Ai.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<User, Integer> {

}
