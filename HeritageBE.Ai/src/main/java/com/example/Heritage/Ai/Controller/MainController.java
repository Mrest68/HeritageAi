package com.example.Heritage.Ai.Controller;

import com.example.Heritage.Ai.Repository.PersonRepository;
import com.example.Heritage.Ai.Service.UserService;
import com.example.Heritage.Ai.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class MainController{

    @Autowired
    PersonRepository personRepository;

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public void addStudent(@RequestBody User user){
        userService.createUser(user.getUsername(), user.getPassword());
    }



}
