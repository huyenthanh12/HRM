package com.example.HRM.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;

    private String email;

    @Column(nullable = false)
    @NonNull
    private String password;

    private int age;

    @JsonAlias("first_name")
    @Column(nullable = false)
    @NonNull
    private String firstName;

    @JsonAlias("last_name")
    @Column(nullable = false)
    @NonNull
    private String lastName;

    private String address;

    private boolean sex;

    private Date startDate;

    private int contractPeriod;

    private String status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roleEntities;

    public UseEntity(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
