package com.example.Heritage.Ai.Repository;

import com.example.Heritage.Ai.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface  PersonRepository extends MongoRepository<User, String> {
    @Query("{username: '?0'}}")

    User findByUsername(String username);

}
