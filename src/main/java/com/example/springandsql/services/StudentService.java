package com.example.springandsql.services;

import com.example.springandsql.dao.StudentRepository;
import com.example.springandsql.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

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

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email's taken");
        }
        System.out.println(student+"new student to add!!!!!!");
        getStudents();
        studentRepository.save(student);
    }


}
