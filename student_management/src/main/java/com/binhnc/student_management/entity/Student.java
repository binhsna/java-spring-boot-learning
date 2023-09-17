package com.binhnc.student_management.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_student_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_student_phone", columnNames = "phone")
        })
@Data
public class Student implements Serializable {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "mame",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(name = "gender")
    private boolean gender = true;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "phone", length = 10, nullable = false)
    private String phone;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "varchar(20)"
    )
    private String email;
    // Mối quan hệ n-1 giữa sinh viên với lớp học
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id", foreignKey = @ForeignKey(name = "fk_student_class"))
    private Classes rl_class_student;
}
