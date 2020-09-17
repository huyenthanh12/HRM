package com.example.HRM.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id = 0;

    @Column(nullable = false)
    @NonNull
    private String name;

    @Column
    @NonNull
    private String description;
}
