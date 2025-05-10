package com.example.Rydo.Service;
import com.example.Rydo.Dtos.UserLoginDTO;
import com.example.Rydo.Dtos.UserRegisterDTO;
import com.example.Rydo.Dtos.UserResponseDTO;
import com.example.Rydo.Entity.User;
import com.example.Rydo.Repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public ResponseEntity<?> CreateUser(UserRegisterDTO dto) {
        if (authRepository.existsByEmail(dto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPhone(dto.getPhone());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        User savedUser = authRepository.save(user);

        UserResponseDTO responseDTO = new UserResponseDTO(
                savedUser.getUserId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getPhone()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }


    public ResponseEntity<?> LoginUser(UserLoginDTO dto) {
        User user = authRepository.findByEmail(dto.getEmail());
        if (user == null || !passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }
        return ResponseEntity.ok("Login successful!");
    }



}
