package ru.physiclabs.physiclabs.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.physiclabs.physiclabs.dto.LabDto;
import ru.physiclabs.physiclabs.model.Lab;
import ru.physiclabs.physiclabs.service.LabService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LabController {
    private final LabService labService;

    @GetMapping("/labs/{id}")
    public ResponseEntity<?> getLabById(@PathVariable("id") Long id) {
        if (!labService.existsLabById(id)) { return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Лабораторная работа не найдена!"); }
        return ResponseEntity.ok(labService.findLabById(id));
    }

    @GetMapping("/labs")
    public ResponseEntity<?> findAllLabs() {
        List<Lab> labs = labService.findAll();
        if (labs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("В данный момент на сайте нет лабораторных работ!");
        }
        return ResponseEntity.ok(labs);
    }

    @GetMapping("/labs/grade-{gradeNum}")
    public ResponseEntity<?> findAllLabsByGrade(@PathVariable("gradeNum") Integer grade) {
        List<Lab> labs = labService.findAllByGrade(grade);
        if (labs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Для этого класса лабораторных работ нет!");
        }
        return ResponseEntity.ok(labs);
    }

    @GetMapping("/labs/delete/{id}")
    public ResponseEntity<?> deleteLabById(@PathVariable("id") Long id) {
        if (!labService.existsLabById(id)) { return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Лабораторная работа не найдена!"); }
        labService.delete(id);
        return ResponseEntity.ok("Лабораторная работа успешно удалена!");
    }

    @PostMapping("/labs/create")
    public ResponseEntity<?> createLab(@RequestBody @Valid LabDto labDto) {
        Lab lab = new Lab();
        lab.setTitle(labDto.getTitle());
        lab.setDescription(labDto.getDescription());
        lab.setVideoUrl(labDto.getVideoUrl());
        lab.setGrade(labDto.getGrade());
        labService.save(lab);
        return ResponseEntity.ok("Лабораторная работа успешно создана!");
    }
}
