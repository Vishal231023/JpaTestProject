package com.codingshuttle.jpa.Tutorial.jpaTuts.controllers;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.StudentEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
@Validated
public class StudentController {

    private  final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentEntity addStudent(@RequestBody StudentEntity studentEntity){
        return studentService.addStudent(studentEntity);
    }

    @GetMapping("/{id}")
    public StudentEntity getStudentById( @PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/{studentId}/assign-professor/{professorId}")
    public StudentEntity assignProfessorsToStudent(@PathVariable Long studentId, @PathVariable Long professorId ){
        return studentService.assignProfessorsToStudent(studentId,professorId);
    }
}
