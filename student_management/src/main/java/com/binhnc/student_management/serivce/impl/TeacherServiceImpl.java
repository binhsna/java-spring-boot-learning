package com.binhnc.student_management.serivce.impl;

import com.binhnc.student_management.entity.Teacher;
import com.binhnc.student_management.repository.TeacherRepository;
import com.binhnc.student_management.serivce.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher save(Teacher entity) {
        return teacherRepository.save(entity);
    }

    @Override
    public List<Teacher> saveAll(List<Teacher> list) {
        return teacherRepository.saveAll(list);
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return teacherRepository.existsById(id);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> findAllById(List<Long> id) {
        return (List<Teacher>) teacherRepository.findAllById(id);
    }

    @Override
    public long count() {
        return teacherRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void delete(Teacher Teacher) {
        teacherRepository.delete(Teacher);
    }

    @Override
    public void deleteAll(List<Teacher> list) {
        teacherRepository.deleteAll(list);
    }

    @Override
    public void deleteAll() {
        teacherRepository.deleteAll();
    }
}
