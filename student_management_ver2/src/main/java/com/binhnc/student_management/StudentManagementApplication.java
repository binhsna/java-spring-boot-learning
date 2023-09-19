package com.binhnc.student_management;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
