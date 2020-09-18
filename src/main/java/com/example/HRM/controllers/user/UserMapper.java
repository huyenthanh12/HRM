package com.example.HRM.controllers.user;

import com.example.HRM.controllers.user.models.User;
import com.example.HRM.entity.RoleEntity;
import com.example.HRM.entity.UserEntity;
import com.example.HRM.services.RoleService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    private RoleService roleService;

    @Mapping(source = ".", target = "roleEntities", qualifiedByName = "mapRoleEntities")
    public abstract UserEntity toUserEntity(User user);

    @Mapping(source = ".", target = "roles", qualifiedByName = "mapRoles")
    public abstract User toUser(UserEntity userEntity);

    public List<User> toUsers(List<UserEntity> userEntities) {
        return userEntities.parallelStream().map(this::toUser).collect(Collectors.toList());
    }

    @Named("mapRoleEntities")
    public List<RoleEntity> mapRoleEntities(User user) {
        List<RoleEntity> roleEntitiesResult = new ArrayList<>();
        if (user.getRoles() != null) {
            for (User.Role role : user.getRoles()) {
                RoleEntity roleEntityFromDatabase = this.roleService.getByName(role.getName());
                roleEntitiesResult.add(roleEntityFromDatabase);
            }
        }
        return roleEntitiesResult;
    }

    @Named("mapRoles")
    public List<User.Role> mapRoles(UserEntity userEntity) {
        List<User.Role> rolesResult = new ArrayList<>();

        for (RoleEntity roleEntity : userEntity.getRoleEntities()) {
            rolesResult.add(
                    User.Role.builder().name(roleEntity.getName()).build()
            );
        }

        return rolesResult;
    }
}
