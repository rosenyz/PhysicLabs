package ru.physiclabs.physiclabs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "labs")
@Data
public class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "date_of_create")
    private LocalDate dateOfCreate;

    @Column(name = "grade")
    private Integer grade;

    @PrePersist
    public void init() {
        this.dateOfCreate = LocalDate.now();
    }
}
