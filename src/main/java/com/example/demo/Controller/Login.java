package com.example.demo.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Dto.GenericResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.demo.Servicelayer.Loginlayer;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.Dto.Loginreq;
import jakarta.servlet.http.Cookie; 
@RestController
@RequestMapping("/login")

public class Login {
    @Autowired
    private Loginlayer loginlayer;

    @PostMapping
    public ResponseEntity<GenericResponse> loginUser(@RequestBody Loginreq loginreq, HttpServletResponse response) {
         String token = loginlayer.loginUser(loginreq);

        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(3600); // 1 hour
        cookie.setSecure(false); // Set to true in production with HTTPS

        response.addCookie(cookie);
       
        return ResponseEntity.ok(new GenericResponse("User logged in successfully"));
    }
    
}
