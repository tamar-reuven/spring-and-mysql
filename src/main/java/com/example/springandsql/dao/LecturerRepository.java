package com.example.springandsql.dao;

import com.example.springandsql.model.Course;
import com.example.springandsql.model.Lecturer;
import com.example.springandsql.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer,Integer> {
    @Override
    List<Lecturer> findAll();

    @Query("SELECT l From Lecturer l WHERE l.lecturerId= ?1")
    Optional<Lecturer> findLecturerById(int LecturerId);
}
