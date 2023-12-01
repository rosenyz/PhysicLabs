package ru.physiclabs.physiclabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.physiclabs.physiclabs.model.Lab;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabRepository extends JpaRepository<Lab, Long> {
    List<Lab> findAllByGrade(Integer grade);
    Optional<Lab> findLabById(Long id);
    Boolean existsLabById(Long id);
    List<Lab> findAll();

    @Transactional
    void deleteLabById(Long id);
}
