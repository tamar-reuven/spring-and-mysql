package com.example.springandsql.controller;

import com.example.springandsql.model.Course;
import com.example.springandsql.model.Lecturer;
import com.example.springandsql.model.Student;
import com.example.springandsql.services.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CollegeController {

 private CollegeService collegeService;

    @Autowired
    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @GetMapping ("/getAllStudents")
    public List<Student> getStudents(){
        return collegeService.getStudents();
    }
    @GetMapping ("/getAllCourses")
    public List<Course> getCourses(){
        return collegeService.getCourses();
    }
    @GetMapping ("/getAllLecturers")
    public List<Lecturer> getLecturers(){
        return collegeService.getLecturers();
    }


    @GetMapping ("/getByGrade")
    public List<Student> getStudentsAccordingToGrade(){
        return collegeService.getStudentsWithGradeGreaterThanX(87);
    }

    @GetMapping ("/getByGradeYouEnter")
    public List<Student> getByGradeYouEnter(@RequestBody String grade){
        System.out.println(grade);
        return collegeService.getStudentsWithGradeGreaterThanX(Integer.parseInt(grade));
    }


    @PostMapping ("/addStudent")
    public void addStudent(@RequestBody Student student){
        collegeService.addNewStudent(student);
    }
    @PostMapping ("/addCourse")
    public void addCourse(@RequestBody Course course){
        collegeService.addNewCourse(course);
    }
    @PostMapping ("/addLecturer")
    public void addLecturer(@RequestBody Lecturer lecturer){
        collegeService.addNewLecturer(lecturer);
    }


    @PutMapping ("/updateStudent")
    public Student updateStudent(@RequestBody Student student){
        return collegeService.updateStudent(student);
    }
    @PutMapping ("/updateCourse")
    public Course updateCourse(@RequestBody Course course){
        return collegeService.updateCourse(course);
    }
    @PutMapping ("/updateLecturer")
    public Lecturer updateLecturer(@RequestBody Lecturer lecturer){
        return collegeService.updateLecturer(lecturer);
    }

    @DeleteMapping ("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id){
        return collegeService.deleteStudent(id);
    }
    @DeleteMapping ("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable int id){
        return collegeService.deleteCourse(id);
    }
    @DeleteMapping ("/deleteLecturer/{id}")
    public String deleteLecturer(@PathVariable int id){
        return collegeService.deleteLecturer(id);
    }

}
