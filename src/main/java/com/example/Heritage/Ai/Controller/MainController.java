package com.example.Heritage.Ai.Controller;

import com.example.Heritage.Ai.Repository.PersonRepository;
import com.example.Heritage.Ai.Service.UserService;
import com.example.Heritage.Ai.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")


@CrossOrigin(origins = "http://localhost:3000")
public class MainController{

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<String> addStudent(@RequestBody User user){

        if(user == null || user.getUsername() == null || user.getPassword() ==null){
            return  ResponseEntity.badRequest().body("User details incomplete");
        }

        try{
            userService.createUser(user.getUsername(), user.getPassword());
            return ResponseEntity.ok("User successfully created");

        }catch(IllegalArgumentException e){
            return ResponseEntity.status(409).body("Username already exist");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error creating user");
        }

    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        if(user == null || user.getUsername()==null || user.getPassword() == null){
            return ResponseEntity.badRequest().body("Incorrect format");
        }
        try{

            User loggedinUser = userService.findByUsername(user.getUsername(), user.getPassword());
            return ResponseEntity.ok("Welcome back!" + loggedinUser);

        }catch (IllegalArgumentException e){
            return ResponseEntity.status(409).body("Incorrect Credentials" + e) ;
        }catch(Exception e){
            return ResponseEntity.status(500).body("Error logging in");
        }


    }



}
