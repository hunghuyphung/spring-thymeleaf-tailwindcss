package vn.java.springthymeleaftailwindcss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.java.springthymeleaftailwindcss.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}