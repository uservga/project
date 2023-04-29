package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents the "groups" table in the Data Base
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_group")
    private String nameGroup;
}