package com.example.repository;

import com.example.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The GroupRepository interface extends the JpaRepository interface
 * Which allows you to perform CRUD operations on entities in the database
 */

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {}