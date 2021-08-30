package com.example.springandsql.dao;

import com.example.springandsql.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Override
    List<Student> findAll();

    @Query("SELECT s From Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Query ("SELECT s From Student s WHERE s.grade > ?1")
    List<Student> findStudentsWithGradeGreaterThanX(int minGrade);

}
