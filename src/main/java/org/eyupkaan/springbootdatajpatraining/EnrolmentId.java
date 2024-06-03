package org.eyupkaan.springbootdatajpatraining;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class EnrolmentId implements Serializable {
    @Column(name = "STUDENT_ID")
    private Long studentId;
    @Column(name = "COURSE_ID")
    private Long courseId;

    public EnrolmentId(){}
    public EnrolmentId(Long studentId, Long courseId){
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrolmentId that = (EnrolmentId) o;
        return Objects.equals(getStudentId(), that.getStudentId()) && Objects.equals(getCourseId(), that.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getCourseId());
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
