package org.eyupkaan.springbootdatajpatraining;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        StudentIdCardRepository studentIdCardRepository
    ){
        return args -> {

            Student jhon = new Student("Jhon", "Doe", "john_doe@jakarta.com", 23);
            jhon.addBook(
                    new Book("Java", LocalDateTime.now().minusDays(4))
            );
            jhon.addBook(
                    new Book("JakartaEE", LocalDateTime.now())
            );
            jhon.addBook(
                    new Book("Spring", LocalDateTime.now().minusMonths(2))
            );

            StudentIdCard studentIdCard = new StudentIdCard("111333555", jhon);
            jhon.setStudentIdCard(studentIdCard);

            jhon.addEnrolment(new Enrolment(
                    new EnrolmentId(1L, 1L),
                    jhon,
                    new Course("Spring Data Jpa", "IT"),
                    LocalDateTime.now()
            ));

            jhon.addEnrolment(new Enrolment(
                    new EnrolmentId(1L, 2L),
                    jhon,
                    new Course("Spring Web", "IT"),
                    LocalDateTime.now().minusDays(8)
            ));

            studentRepository.save(jhon);

            studentRepository.findById(1L)
                    .ifPresent(s -> {
                        System.out.println("fetch book lazy...");
                        List<Book> books = jhon.getBooks();
                        books.forEach(book -> {
                            System.out.println(
                                    s.getFirstName() + " --> " + book.getBookName()
                            );
                        });
                    });
        };
    }

}
