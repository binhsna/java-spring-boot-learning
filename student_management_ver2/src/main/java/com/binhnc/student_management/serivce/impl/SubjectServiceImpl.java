package com.binhnc.student_management.serivce.impl;

import com.binhnc.student_management.entity.Subject;
import com.binhnc.student_management.repository.SubjectRepository;
import com.binhnc.student_management.serivce.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject save(Subject entity) {
        return subjectRepository.save(entity);
    }

    @Override
    public List<Subject> saveAll(List<Subject> list) {
        return subjectRepository.saveAll(list);
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return subjectRepository.existsById(id);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public List<Subject> findAllById(List<Long> id) {
        return (List<Subject>) subjectRepository.findAllById(id);
    }

    @Override
    public long count() {
        return subjectRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public void delete(Subject Subject) {
        subjectRepository.delete(Subject);
    }

    @Override
    public void deleteAll(List<Subject> list) {
        subjectRepository.deleteAll(list);
    }

    @Override
    public void deleteAll() {
        subjectRepository.deleteAll();
    }
}
