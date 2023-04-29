package com.example.dto;

import lombok.Data;

/**
 * Class that is a Data Transfer Object for use in registration users in an application
 */

@Data
public class RegistrationDto {
    private String name;
    private String username;
    private String email;
    private String password;
}