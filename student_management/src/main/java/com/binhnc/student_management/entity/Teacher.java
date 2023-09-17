package com.binhnc.student_management.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "Teacher")
@Table(name = "teacher",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_teacher_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_teacher_phone", columnNames = "phone")
        })
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "gender")
    private boolean gender;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "phone", length = 10, nullable = false)
    private String phone;
    @Column(name = "email", nullable = false, length = 20)
    private String email;
    // Mối quan hệ n-n giữa giáo viên với môn học
    @ManyToMany(mappedBy = "rl_subject_teacher")
    private List<Subject> rl_teacher_subject;

}
