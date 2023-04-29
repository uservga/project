package com.example.repository;

import com.example.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * The RoleRepository interface extends the JpaRepository interface
 * Which allows you to perform CRUD operations on entities in the database
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}