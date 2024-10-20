package com.example.Heritage.Ai.Service;

import com.example.Heritage.Ai.Repository.PersonRepository;
import com.example.Heritage.Ai.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private PersonRepository repo;

//    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public void createUser(String username, String password){
        User existingUser = repo.findByUsername(username);

        if(existingUser != null){
            throw new IllegalArgumentException("Username already exist");
        }
//        String hashPassword = passwordEncoder.encode(password);

        User User = new User(username, password);
        repo.save(User);
    }

    public User findByUsername(String username,String password){
        User existingUser = repo.findByUsername(username);
        if(existingUser ==null){
            throw new IllegalArgumentException("User doesnt exist");
        }
        if(!existingUser.getPassword().equals(password)){
            throw new IllegalArgumentException("Incorrect credentials");
        }

        return repo.findByUsername(username);
    }
}
