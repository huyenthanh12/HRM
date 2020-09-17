package com.example.HRM.repositories.Roles;

import com.example.HRM.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByName(String name);
}
