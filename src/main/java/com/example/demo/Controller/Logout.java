package com.example.demo.Controller;

import com.example.demo.Dto.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/logout")
public class Logout  {

    @PostMapping
    public ResponseEntity<GenericResponse> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("token", null); 
        cookie.setHttpOnly(true);
        cookie.setSecure(true); 
        cookie.setPath("/");
        cookie.setMaxAge(0); 

        response.addCookie(cookie);

        return ResponseEntity.ok(new GenericResponse("User logged out successfully"));
    }
    
}
