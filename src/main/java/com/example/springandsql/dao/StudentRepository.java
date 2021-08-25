package com.example.springandsql.dao;

import com.example.springandsql.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Override
    List<Student> findAll();


//    List<Student> findAllByName(String name);

}
