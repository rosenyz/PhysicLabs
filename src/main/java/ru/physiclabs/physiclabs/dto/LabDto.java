package ru.physiclabs.physiclabs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LabDto {
    @NotBlank
    private String title;
    private String description;
    @NotBlank
    private String videoUrl;
    @NotNull
    private Integer grade;
}
