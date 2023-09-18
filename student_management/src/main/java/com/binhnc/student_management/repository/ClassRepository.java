package com.binhnc.student_management.repository;

import com.binhnc.student_management.entity.Classes;
import com.binhnc.student_management.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClassRepository extends JpaRepository<Classes, Long> {
    @Query(value = "select distinct * from subject", nativeQuery = true)
    List<Object[]> listSubject();
}
