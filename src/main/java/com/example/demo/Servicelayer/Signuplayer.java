    package com.example.demo.Servicelayer;

    import com.example.demo.Dto.UserRequestDTO;
    import com.example.demo.Model.User;
    import com.example.demo.Model.Userrole;
    import com.example.demo.Repository.UserRepository;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


    @Service
    public class Signuplayer {
        @Autowired
        private UserRepository userRepository;

        @Autowired
        private BCryptPasswordEncoder passwordEncoder;

        public User registerUser(UserRequestDTO userRequestDTO) {
            String roleStr = userRequestDTO.getRole().toUpperCase();

    if (!roleStr.equals("ADMIN") && !roleStr.equals("USER")) {
        throw new IllegalArgumentException("Role must be either ADMIN or USER");
    }

    if (userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()) {
    throw new RuntimeException("Email already exists");
}

        
            User user = User.builder()
                    .name(userRequestDTO.getName())
                    .email(userRequestDTO.getEmail())
                    .password(passwordEncoder.encode(userRequestDTO.getPassword()))
                    .role(Userrole.valueOf(roleStr)) 
                    .build();
        

        





            return userRepository.save(user);
        }

        
    }
