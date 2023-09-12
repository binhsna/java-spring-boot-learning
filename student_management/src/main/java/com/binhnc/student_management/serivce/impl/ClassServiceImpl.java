package com.binhnc.student_management.serivce.impl;

import com.binhnc.student_management.entity.Classes;
import com.binhnc.student_management.repository.ClassRepository;
import com.binhnc.student_management.serivce.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public Classes save(Classes entity) {
        return classRepository.save(entity);
    }

    @Override
    public List<Classes> saveAll(List<Classes> list) {
        return classRepository.saveAll(list);
    }

    @Override
    public Optional<Classes> findById(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return classRepository.existsById(id);
    }

    @Override
    public List<Classes> findAll() {
        return classRepository.findAll();
    }

    @Override
    public List<Classes> findAllById(List<Long> id) {
        return (List<Classes>) classRepository.findAllById(id);
    }

    @Override
    public long count() {
        return classRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        classRepository.deleteById(id);
    }

    @Override
    public void delete(Classes Class) {
        classRepository.delete(Class);
    }

    @Override
    public void deleteAll(List<Classes> list) {
        classRepository.deleteAll(list);
    }

    @Override
    public void deleteAll() {
        classRepository.deleteAll();
    }
}
