package com.binhnc.student_management.serivce;


import com.binhnc.student_management.entity.Classes;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    Classes save(Classes entity);

    List<Classes> saveAll(List<Classes> list);

    Optional<Classes> findById(Long id);

    boolean existsById(Long id);

    List<Classes> findAll();

    List<Classes> findAllById(List<Long> id);

    long count();

    void deleteById(Long id);

    void delete(Classes Class);

    void deleteAll(List<Classes> list);

    void deleteAll();
}
