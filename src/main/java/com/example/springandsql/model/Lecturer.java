package com.example.springandsql.model;

import javax.persistence.*;

@Entity
@Table(name = "lecturer")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "l_id")
    private int lecturerId;
    @Column (name = "l_name")
    private String lecturerName;
    @Column (name = "years")
    private int years;

    public Lecturer(int lecturerId, String lecturerName, int years) {
        this.lecturerId = lecturerId;
        this.lecturerName = lecturerName;
        this.years = years;
    }

    public Lecturer() {
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturerId=" + lecturerId +
                ", lecturerName='" + lecturerName + '\'' +
                ", years=" + years +
                '}';
    }
}
