package com.binhnc.student_management.serivce;

import com.binhnc.student_management.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(Student entity);

    List<Student> saveAll(List<Student> list);

    Optional<Student> findById(Long id);

    boolean existsById(Long id);

    List<Student> findAll();

    List<Student> findAllById(List<Long> id);

    long count();

    void deleteById(Long id);

    void delete(Student student);

    void deleteAll(List<Student> list);

    void deleteAll();
}
