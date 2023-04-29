package com.example.dto;

import lombok.Data;

/**
 * Class that is a Data Transfer Object for displaying information about groups
 */

@Data
public class GroupDto {
    private Long id;
    private String name;
}