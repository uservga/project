package com.example.entity;

import lombok.*;
import jakarta.persistence.*;

/**
 * Represents the "roles" table in the Data Base
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60)
    private String name;
}