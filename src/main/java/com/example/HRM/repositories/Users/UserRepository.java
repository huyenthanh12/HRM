package com.example.HRM.repositories.Users;

import com.example.HRM.entity.UseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserRepository extends JpaRepository<UseEntity, Integer> {

    Optional<UseEntity> findByEmail(String email);

    UseEntity findByUsername(String username);
}
