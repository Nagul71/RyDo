package com.example.Rydo.Repository;
import com.example.Rydo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);

    User findByEmail(String email);
}
