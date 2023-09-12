package com.binhnc.student_management.repository;

import com.binhnc.student_management.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassRepository extends JpaRepository<Classes, Long> {

}
