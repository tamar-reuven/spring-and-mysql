package com.example.springandsql.dao;

import com.example.springandsql.model.Course;
import com.example.springandsql.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    @Override
    List<Course> findAll();

    @Query("SELECT c From Course c WHERE c.courseId = ?1")
    Optional<Course> findCourseById(int courseId);
}
