package com.example.springandsql.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
   @Id
   @GeneratedValue (strategy = GenerationType.AUTO)
   @Column (name = "s_id")
   private int id;
   @Column (name = "s_name")
   private String name;
   @Column (name = "s_last_name")
   private String lastName;
   @Column (name = "s_email")
   private String email;
   @Column (name = "s_grade")
   private int grade;
   @Column (name = "course_id")
   private int courseId;


    public Student(int id, String name, String lastName, String email, int grade, int courseId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.grade = grade;
        this.courseId = courseId;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", grade=" + grade +
                ", courseId=" + courseId +
                '}';
    }
}
