package com.example.HRM.controllers.user.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private int id;

    private String username;

    private String email;

    private String password;

    private int age;

    private String firstName;

    private String lastName;

    private String address;

    private boolean sex;

    @Builder.Default
    private Date startDate = new Date();

    private int contractPeriod;

    private String status;

    private List<Role> roles;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Role {
        private String name;
    }
}
