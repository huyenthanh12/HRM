package com.example.HRM.configurations;

import com.example.HRM.entity.RoleEntity;
import com.example.HRM.entity.UseEntity;
import com.example.HRM.repositories.Roles.RoleRepository;
import com.example.HRM.repositories.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@Configuration
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private void addRoleIfMissing(String name) {
        if (roleRepository.findByName(name)==null) {
            roleRepository.save(RoleEntity.builder().name(name).description("description").build());
        }
    }

    private void addUserIfMissing(String username, String password, String... roles){
        if (userRepository.findByUsername(username) == null) {
            UseEntity user = new UseEntity(username, "default@password", "Last name", new BCryptPasswordEncoder().encode(password));

            user.setRoleEntities(new HashSet<>());

            for (String role: roles) {
                user.getRoleEntities().add(roleRepository.findByName(role));
            }

            userRepository.save(user);
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        addRoleIfMissing("ROLE_ADMIN");
        addRoleIfMissing("ROLE_MEMBER");

        addUserIfMissing("user", "456", "ROLE_MEMBER");
        addUserIfMissing("admin", "1234", "ROLE_MEMBER", "ROLE_ADMIN");
    }
}