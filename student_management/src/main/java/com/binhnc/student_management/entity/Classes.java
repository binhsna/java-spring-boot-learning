package com.binhnc.student_management.entity;

import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "ClassQL")
@Table(name = "class")
@Getter
@Setter
public class Classes implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    // Mối quan hệ 1-n giữa lớp học và sinh viên(học sinh)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rl_class_student", cascade = CascadeType.ALL)
    private List<Student> rl_student_class;
    // Mối quan hệ n-n giữa lớp học và môn học
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "rl_class_subject",
            joinColumns = @JoinColumn(name = "class_id", foreignKey = @ForeignKey(name = "fk_class_subject_class_id")),
            inverseJoinColumns = @JoinColumn(name = "subject_id", foreignKey = @ForeignKey(name = "fk_class_subject_subject_id")))
    private List<Subject> rl_class_subject;

}
