package com.binhnc.student_management.serivce;

import com.binhnc.student_management.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    Teacher save(Teacher entity);

    List<Teacher> saveAll(List<Teacher> list);

    Optional<Teacher> findById(Long id);

    boolean existsById(Long id);

    List<Teacher> findAll();

    List<Teacher> findAllById(List<Long> id);

    long count();

    void deleteById(Long id);

    void delete(Teacher Teacher);

    void deleteAll(List<Teacher> list);

    void deleteAll();
}
