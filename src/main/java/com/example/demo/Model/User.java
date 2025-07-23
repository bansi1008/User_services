package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "users")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Userrole  role;


}
