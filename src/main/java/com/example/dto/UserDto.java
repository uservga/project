package com.example.dto;

import lombok.Data;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that is a Data Transfer Object for displaying user-owned groups
 */

@Data
public class UserDto {
    private Long id;
    private String name;
    private Set<String> groupNames = new HashSet<>();
}