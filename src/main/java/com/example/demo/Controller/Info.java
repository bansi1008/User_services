package com.example.demo.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.Dto.GenericResponse;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Utility.JWT;
import com.example.demo.Model.User;
import com.example.demo.Dto.UserResponse;


@RestController
@RequestMapping("/me")


public class Info {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWT jwtUtil;

    @GetMapping
    public ResponseEntity<?> getUserInfo(@CookieValue(value = "token", required = false) String token) {
       if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new GenericResponse("Unauthorized: No token found"));
        }
        try{
            String email = jwtUtil.getEmailFromToken(token);
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        
       UserResponse userResponse = new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getRole().toString());
            return ResponseEntity.ok(userResponse);
        }

    
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new GenericResponse("Error retrieving user information: " + e.getMessage()));
        }   
    
    }

    
}
