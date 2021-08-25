package com.example.springandsql.services;

import com.example.springandsql.dao.StudentRepository;
import com.example.springandsql.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public List<Student> getStudents(){
        return (List<Student>) studentRepository.findAll();
    }

    public String Test(){
        String name="just checking";
        return name;
    }

//    public List<Student> getStudentsByName(String name) {
//        return studentRepository.findAllByName(name);
//    }
}
