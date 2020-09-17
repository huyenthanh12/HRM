package com.example.HRM.services;

import com.example.HRM.controllers.user.Exception.UserNotFoundException;
import com.example.HRM.entity.UserEntity;
import com.example.HRM.repositories.Users.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserEntity add(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

    public UserEntity getById(int id) {
        return this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
    }

    public List<UserEntity> getAllUsers() {
        return this.userRepository.findAll();
    }

    public void deleteUserById(int id) {
        UserEntity userEntity = this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        this.userRepository.delete(userEntity);
    }
}
