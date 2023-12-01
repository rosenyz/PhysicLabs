package ru.physiclabs.physiclabs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.physiclabs.physiclabs.model.Lab;
import ru.physiclabs.physiclabs.repository.LabRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LabService {
    private final LabRepository labRepository;

    public List<Lab> findAllByGrade(Integer grade) {
        return labRepository.findAllByGrade(grade);
    }

    public List<Lab> findAll() {
        return labRepository.findAll();
    }

    public Lab findLabById(Long id) {
        return labRepository.findLabById(id).orElseThrow(
                () -> new IllegalArgumentException(
                        "Such a lab not exists!")
        );
    }

    public Boolean existsLabById(Long id) {
        return labRepository.existsLabById(id);
    }

    public void save(Lab lab) {
        labRepository.save(lab);
    }

    public void delete(Long id) {
        labRepository.deleteLabById(id);
    }
}
