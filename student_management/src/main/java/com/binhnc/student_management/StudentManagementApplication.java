package com.binhnc.student_management;

import com.binhnc.student_management.entity.Student;
import com.binhnc.student_management.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
//        return args -> {
//            Student s = new Student(
//                    "Binh",
//                    "Nguyen Cong",
//                    "binhsna@gmail.com",
//                    21
//            );
//            studentRepository.save(s);
//        };
//    }
}
