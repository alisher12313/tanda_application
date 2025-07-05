package kz.tandaApplication.SpringApplication.dto;

import lombok.Data;

@Data
public class AuthDto {
    private String username;
    private String password;
    private Role role;
}

