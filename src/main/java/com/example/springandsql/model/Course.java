package com.example.springandsql.model;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "c_id")
    private int courseId;
    @Column (name = "c_name")
    private String courseName;
    @Column (name = "c_lecturer")
    private String courseLecturer;
    @Column (name = "hours")
    private int hours;

    public Course(int courseId, String courseName, String courseLecturer, int hours) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseLecturer = courseLecturer;
        this.hours = hours;
    }

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseLecturer() {
        return courseLecturer;
    }

    public void setCourseLecturer(String courseLecturer) {
        this.courseLecturer = courseLecturer;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseLecturer='" + courseLecturer + '\'' +
                ", hours=" + hours +
                '}';
    }
}
