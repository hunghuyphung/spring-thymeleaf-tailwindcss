package vn.java.springthymeleaftailwindcss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.java.springthymeleaftailwindcss.entity.User;

import java.util.Optional;

public interface SystemUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
