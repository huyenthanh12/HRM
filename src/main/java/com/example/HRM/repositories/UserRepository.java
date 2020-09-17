package com.example.HRM.repositories;

import com.example.HRM.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Iterable<User> findByNameContaining(String pattern);
}
