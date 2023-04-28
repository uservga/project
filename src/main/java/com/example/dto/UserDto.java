package com.example.dto;

import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String name;
    private Set<String> groupNames = new HashSet<>();
}