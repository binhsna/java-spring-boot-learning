package com.binhnc.student_management.serivce;

import com.binhnc.student_management.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    Subject save(Subject entity);

    List<Subject> saveAll(List<Subject> list);

    Optional<Subject> findById(Long id);

    boolean existsById(Long id);

    List<Subject> findAll();

    List<Subject> findAllById(List<Long> id);

    long count();

    void deleteById(Long id);

    void delete(Subject Subject);

    void deleteAll(List<Subject> list);

    void deleteAll();
}
