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


    @RequestMapping("/test")
    public String test(){
        return collegeService.Test();
    }

    @PostMapping ("/addStudent")
    public void addStudent(@RequestBody Student student){
        collegeService.addNewStudent(student);
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
    @PostMapping ("/addCourse")
    public void addCourse(@RequestBody Course course){
        collegeService.addNewCourse(course);
    }
}
