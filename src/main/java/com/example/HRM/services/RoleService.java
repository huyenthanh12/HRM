package com.example.HRM.services;

import com.example.HRM.controllers.role.exception.RoleNotFoundException;
import com.example.HRM.entity.RoleEntity;
import com.example.HRM.repositories.Roles.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService {

    // khi dung @RequiredArgsConstructor ko can @autowire chi can final
    private final RoleRepository roleRepository;

    public RoleEntity getByName(String name) {
        return this.roleRepository.findByName(name).orElseThrow(() -> new RoleNotFoundException());
    }
}
