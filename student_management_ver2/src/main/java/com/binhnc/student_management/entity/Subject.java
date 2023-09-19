package com.binhnc.student_management.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity(name = "Subject")
@Table(name = "subject")
public class Subject implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    // Mối quan hệ n-n giữa môn học với lớp học
    @ManyToMany(mappedBy = "rl_class_subject", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Classes> rl_subject_class;
    // Mối quan hệ n-n giữa môn học với giáo viên
    @ManyToMany(mappedBy = "rl_teacher_subject", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Teacher> rl_subject_teacher;
}
