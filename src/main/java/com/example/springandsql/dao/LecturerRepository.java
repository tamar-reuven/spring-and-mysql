package com.example.springandsql.dao;

import com.example.springandsql.model.Lecturer;
import com.example.springandsql.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LecturerRepository extends JpaRepository<Lecturer,Integer> {
    @Override
    List<Lecturer> findAll();
}
