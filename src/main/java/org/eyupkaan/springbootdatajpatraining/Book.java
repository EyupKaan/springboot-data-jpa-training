package org.eyupkaan.springbootdatajpatraining;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "BOOK")
@Table(name = "BOOK")
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @Column(
            name = "ID",
            updatable = false
    )
    private Long id;
    @Column(
            name = "CREATED_AT",
            nullable = false
    )
    private LocalDateTime createdAt;
    @Column(
            name = "BOOK_NAME",
            nullable = false
    )
    private String bookName;

    @ManyToOne
    @JoinColumn(
            name = "STUDENT_ID",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "student_book_fk")
    )
    private Student student;

    public Book() {
    }

    public Book(LocalDateTime createdAt, String bookName, Student student) {
        this.createdAt = createdAt;
        this.bookName = bookName;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", bookName='" + bookName + '\'' +
                ", student=" + student +
                '}';
    }
}
