package com.example.Heritage.Ai.Service;

import com.example.Heritage.Ai.Repository.PersonRepository;
import com.example.Heritage.Ai.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PersonRepository repo;

    public void createUser(String username, String password){
        User User = new User(username, password);
        repo.save(User);
    }
}
