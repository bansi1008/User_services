package com.example.demo.Servicelayer;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import com.example.demo.Repository.UserRepository;
import com.example.demo.Utility.JWT;
import com.example.demo.Model.User;
import com.example.demo.Dto.Loginreq;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;


    @Service
public class Loginlayer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JWT jwtUtil;


    public String loginUser(Loginreq loginreq) {
        User user = userRepository.findByEmail(loginreq.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(loginreq.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

     
        

       return jwtUtil.generateToken(user.getEmail());
    }
    
}
