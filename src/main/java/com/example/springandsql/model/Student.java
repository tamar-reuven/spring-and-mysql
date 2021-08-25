package com.example.springandsql.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
   @Id
   @GeneratedValue (strategy = GenerationType.AUTO)

   @Column (name = "id")
   private int id;
   @Column (name = "student_name")
   private String name;
   @Column (name = "Student_email")
   private String email;

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}'+'\n';
    }
}
