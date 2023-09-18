package com.binhnc.student_management.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
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
    private boolean gender = true;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "phone", length = 10, nullable = false)
    private String phone;
    @Column(name = "email", nullable = false, length = 20)
    private String email;
    // Mối quan hệ n-n giữa giáo viên với môn học
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "rl_teacher_subject",
            joinColumns = @JoinColumn(name = "teacher_id", foreignKey = @ForeignKey(name = "fk_teacher_subject_teacher_id")),
            inverseJoinColumns = @JoinColumn(name = "subject_id", foreignKey = @ForeignKey(name = "fk_teacher_subject_subject_id")))
    private List<Subject> rl_teacher_subject;

}
