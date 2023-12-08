package ru.physiclabs.physiclabs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterDto {
    @Email
    private String email;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String password;
}
