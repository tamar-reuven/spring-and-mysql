package com.example.springandsql.services;

import com.example.springandsql.dao.CourseRepository;
import com.example.springandsql.dao.LecturerRepository;
import com.example.springandsql.dao.StudentRepository;
import com.example.springandsql.model.Course;
import com.example.springandsql.model.Lecturer;
import com.example.springandsql.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private LecturerRepository lecturerRepository;
    @Autowired
    public CollegeService(StudentRepository studentRepository, CourseRepository courseRepository, LecturerRepository lecturerRepository){
        this.studentRepository=studentRepository;
        this.courseRepository=courseRepository;
        this.lecturerRepository=lecturerRepository;
    }

    public List<Student> getStudents(){ return studentRepository.findAll(); }
    public List<Course> getCourses(){ return courseRepository.findAll();}
    public List<Lecturer> getLecturers(){ return lecturerRepository.findAll();}

    public String Test(){
        String name="just checking";
        return name;
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email's taken");
        }
        System.out.println(student+" new student to add!!!!!!");
        studentRepository.save(student);
        getStudents();
    }

    public void addNewCourse(Course course){
        Optional<Course> courseOptional = courseRepository.findCourseById(course.getCourseId());
        if(courseOptional.isPresent()){
            throw new IllegalStateException("course already exists");
        }
        System.out.println(course+" new course to add!!!!!!");
        courseRepository.save(course);
    }

    public List<Student> getStudentsWithGradeGreaterThanX(int minGrade){
        return (List<Student>) studentRepository.findStudentsWithGradeGreaterThanX(minGrade);
    }


}
