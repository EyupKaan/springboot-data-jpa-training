package org.eyupkaan.springbootdatajpatraining;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "COURSE")
@Table(name = "COURSE")
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "department",
            nullable = false
    )
    private String department;
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "course"
    )
    private List<Enrolment> enrollments = new ArrayList<Enrolment>();

    public Course() {
    }

    public Course(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Enrolment> getEnrollments() {
        return enrollments;
    }

    public void addEnrollment(Enrolment enrollment) {
        if (!enrollments.contains(enrollment))
            enrollments.add(enrollment);
    }

    public void removeEnrolment(Enrolment enrolment) {
        enrollments.remove(enrolment);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", enrollments=" + enrollments +
                '}';
    }
}
