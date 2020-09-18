package com.example.HRM.services;

import com.example.HRM.entity.RoleEntity;
import com.example.HRM.entity.UserEntity;
import com.example.HRM.repositories.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component("userDetail")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<UserEntity> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            UserEntity emailEntity = userOpt.get();

            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

            Set<RoleEntity> roles = (Set<RoleEntity>) emailEntity.getRoleEntities();

            for (RoleEntity role : roles) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }

            return new org.springframework.security.core.userdetails.User(
                    emailEntity.getEmail(), emailEntity.getPassword(), grantedAuthorities
            );
        }
        throw new UsernameNotFoundException("User not found");
    }
}
