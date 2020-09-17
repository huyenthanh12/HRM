package com.example.HRM.controllers;

import com.example.HRM.entity.UseEntity;
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
    Iterable<UseEntity> get(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<UseEntity> get(@PathVariable int id){
        return userRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id){
        userRepository.deleteById(id);
    }

    @PostMapping()
    void post(@RequestBody UseEntity user){
        userRepository.save(user);
    }

    @PutMapping
    void put(@RequestBody UseEntity user){
       userRepository.save(user);
    }

//    @GetMapping("/find")
//    Iterable<User> find(@PathVariable String pattern){
//        return userRepository.findByName(pattern);
//    }
}
