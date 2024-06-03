package org.eyupkaan.springbootdatajpatraining;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class ApplicationTests {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    void contextLoads() {
        Student student = new Student("Jhon", "Doe", "john_doe@jakarta.com", 23);
        studentRepository.save(student);
        Optional<Student> foundStudent = studentRepository.findById(student.getId());
        assertThat(foundStudent).isPresent();
        assertThat(foundStudent.get().getFirstName()).isEqualTo("Jhon");
        assertThat(foundStudent.get().getLastName()).isEqualTo("Doe");
        assertThat(foundStudent.get().getEmail()).isEqualTo("john_doe@jakarta.com");
        assertThat(foundStudent.get().getAge()).isEqualTo(23);

    }

}
