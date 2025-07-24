package com.example.demo.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String role;

    
}
