package com.example.dto;

import lombok.Data;

/**
 * Class that is a Data Transfer Object for use in login users in an application
 */

@Data
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}