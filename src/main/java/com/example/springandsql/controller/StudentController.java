package com.example.springandsql.controller;

import com.example.springandsql.model.Student;
import com.example.springandsql.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class StudentController {

 private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping ("/getAll")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @RequestMapping("/test")
    public String test(){
        return studentService.Test();
    }

    @PostMapping ("/addStudent")
    public void addStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
}
