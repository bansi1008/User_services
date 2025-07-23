package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.UserRequestDTO;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Servicelayer.Signuplayer;
import com.example.demo.Dto.GenericResponse;
import org.springframework.http.ResponseEntity;



import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/signup")

public class Signup {
    @Autowired
    private Signuplayer signuplayer;
    

    @PostMapping
    public ResponseEntity<GenericResponse> registerUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
         signuplayer.registerUser(userRequestDTO);
         return ResponseEntity.ok(new GenericResponse("User registered successfully")); 
    }

    
}
