package com.example.springandsql.controller;

import com.example.springandsql.model.Student;
import com.example.springandsql.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/world")
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

//    @RequestMapping ("/byName/(name)")
//    public List<Student> byStudentName(@PathVariable(value = "name") String name){
//        return studentService.getStudentsByName(name);
//    }
}
