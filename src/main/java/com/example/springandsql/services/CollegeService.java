package com.example.springandsql.services;

import com.example.springandsql.dao.CourseRepository;
import com.example.springandsql.dao.LecturerRepository;
import com.example.springandsql.dao.StudentRepository;
import com.example.springandsql.model.Course;
import com.example.springandsql.model.Lecturer;
import com.example.springandsql.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
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

    public List<Student> getStudents(){ return studentRepository.findAll();}
    public List<Course> getCourses(){ return courseRepository.findAll();}
    public List<Lecturer> getLecturers(){ return lecturerRepository.findAll();}


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
    public void addNewLecturer(Lecturer lecturer) {
        Optional<Lecturer> lecturerOptional = lecturerRepository.findLecturerById(lecturer.getLecturerId());
        if(lecturerOptional.isPresent()){
            throw new IllegalStateException("lecturer already exists");
        }
        System.out.println(lecturer+" new lecturer to add!!!!!!");
        lecturerRepository.save(lecturer);
    }

    public List<Student> getStudentsWithGradeGreaterThanX(int minGrade){
        return studentRepository.findStudentsWithGradeGreaterThanX(minGrade);
    }


    public Student updateStudent(Student student) {
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        isExist(existingStudent);
        return studentRepository.save(student);
    }

    public Course updateCourse(Course course) {
        Course existingCourse = courseRepository.findCourseById(course.getCourseId()).orElse(null);
        isExist(existingCourse);
        return courseRepository.save(course);
    }

    public Lecturer updateLecturer(Lecturer lecturer) {
        Lecturer existingLecturer  = lecturerRepository.findLecturerById(lecturer.getLecturerId()).orElse(null);
        isExist(existingLecturer);
        return lecturerRepository.save(lecturer);
    }

    public String deleteStudent(int studentId){
        Student existingStudent = studentRepository.findById(studentId).orElse(null);
        isExist(existingStudent);
        studentRepository.deleteById(studentId);
        return "student "+studentId +" was deleted";
    }

    public String deleteCourse(int courseId) {
        Course existingCourse = courseRepository.findCourseById(courseId).orElse(null);
        isExist(existingCourse);
        courseRepository.deleteById(courseId);
        return "course "+courseId +" was deleted";
    }

    public String deleteLecturer(int lecturerId) {
        Lecturer existingLecturer=lecturerRepository.findLecturerById(lecturerId).orElse(null);
        isExist(existingLecturer);
        lecturerRepository.deleteById(lecturerId);
        return "lecturer "+ lecturerId +" was deleted";
    }

    public void isExist(Object o){
        if(o==null){
            throw new IllegalStateException( o.getClass()+"  doesn't exist");
        }
        return;
    }


}
