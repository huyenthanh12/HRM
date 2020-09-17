package com.example.HRM.controllers;

import com.example.HRM.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.HRM.repositories.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    Iterable<User> get(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<User> get(@PathVariable int id){
        return userRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        userRepository.deleteById(id);
    }

    @PostMapping()
    void post(@RequestBody User user){
        user.setId(0);
        userRepository.save(user);
    }

    @PutMapping
    void put(@RequestBody User user){
       userRepository.save(user);
    }

    @GetMapping("/find")
    Iterable<User> find(@PathVariable String pattern){
        return userRepository.findByNameContaining(pattern);
    }
}
