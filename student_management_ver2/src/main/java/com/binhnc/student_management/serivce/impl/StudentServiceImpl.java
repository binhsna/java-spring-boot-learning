package com.binhnc.student_management.serivce.impl;

import com.binhnc.student_management.entity.Student;
import com.binhnc.student_management.repository.StudentRepository;
import com.binhnc.student_management.serivce.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student entity) {
        return studentRepository.save(entity);
    }

    @Override
    public List<Student> saveAll(List<Student> list) {
        return studentRepository.saveAll(list);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllById(List<Long> id) {
        return (List<Student>) studentRepository.findAllById(id);
    }

    @Override
    public long count() {
        return studentRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public void deleteAll(List<Student> list) {
        studentRepository.deleteAll(list);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
