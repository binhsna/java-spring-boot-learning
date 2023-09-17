package com.binhnc.student_management.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "Subject")
@Table(name = "subject")
@Data
public class Subject implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    // Mối quan hệ n-n giữa môn học với lớp học
    @ManyToMany(mappedBy = "rl_class_subject")
    private List<Classes> rl_subject_class;
    // Mối quan hệ n-n giữa môn học với giáo viên
    @ManyToMany
    @JoinTable(name = "rl_subject_teacher",
            joinColumns = @JoinColumn(name = "subject_id", foreignKey = @ForeignKey(name = "fk_subject_teacher_subject_id")),
            inverseJoinColumns = @JoinColumn(name = "teacher_id", foreignKey = @ForeignKey(name = "fk_subject_teacher_teacher_id")))
    private List<Teacher> rl_subject_teacher;
}
