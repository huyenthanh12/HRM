package com.example.HRM.controllers;

import com.example.HRM.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.HRM.repositories.Users.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    Iterable<UserEntity> get(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<UserEntity> get(@PathVariable int id){
        return userRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        userRepository.deleteById(id);
    }

    @PostMapping()
    void post(@RequestBody UserEntity user){
        userRepository.save(user);
    }

    @PutMapping
    void put(@RequestBody UserEntity user){
       userRepository.save(user);
    }

//    @GetMapping("/find")
//    Iterable<User> find(@PathVariable String pattern){
//        return userRepository.findByName(pattern);
//    }
}
