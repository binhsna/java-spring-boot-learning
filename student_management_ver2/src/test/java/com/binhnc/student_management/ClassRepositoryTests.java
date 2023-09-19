package com.binhnc.student_management;

import com.binhnc.student_management.entity.Classes;
import com.binhnc.student_management.repository.ClassRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ClassRepositoryTests {
    @Autowired
    private ClassRepository repo;

//    @Test
//    void testAddNew() {
//        for (int i = 1; i < 11; i++) {
//            Classes c = new Classes();
//            c.setName("64PM" + i);
//
//            Classes saveClass = repo.save(c);
//            Assertions.assertThat(saveClass).isNotNull();
//            Assertions.assertThat(saveClass.getId()).isGreaterThan(0);
//        }
//    }

    @Test
    public void testListAll() {
        List<Classes> classes = repo.findAll();
        Assertions.assertThat(classes).hasSizeGreaterThan(0);

        for (Classes c : classes) {
            System.out.println(c);
        }
    }

//    @Test
//    public void testUpdate() {
//        Long classid = Long.valueOf(1);
//        Optional<Classes> optionalClasses = repo.findById(classid);
//        Classes c = optionalClasses.get();
//        c.setName("test update");
//
//        repo.save(c);
//        Classes updateClass = repo.findById(classid).get();
//        Assertions.assertThat(updateClass.getName()).isEqualTo("test update");
//
//    }

//    @Test
//    public void testGet() {
//        Long classid = Long.valueOf(10);
//        Optional<Classes> optionalClasses = repo.findById(classid);
//
//        Assertions.assertThat(optionalClasses).isPresent();
//        System.out.println(optionalClasses.get());
//
//    }
//    @Test
//    public void testDelete(){
//        Long classid = Long.valueOf(10);
//        repo.deleteById(classid);
//
//        Optional<Classes> optionalClasses=repo.findById(classid);
//        Assertions.assertThat(optionalClasses).isNotPresent();
//    }
}
