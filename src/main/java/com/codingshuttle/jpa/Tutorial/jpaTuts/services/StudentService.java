package com.codingshuttle.jpa.Tutorial.jpaTuts.services;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.StudentEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.AdmissionRecordRepository;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentService {

    private final StudentRepository studentRepository;
    private final AdmissionRecordRepository admissionRecordRepository;

    public StudentService(StudentRepository studentRepository, AdmissionRecordRepository admissionRecordRepository) {
        this.studentRepository = studentRepository;
        this.admissionRecordRepository = admissionRecordRepository;
    }

    public StudentEntity addStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity getStudentById(Long id) {
       Optional<StudentEntity> studentEntity =  studentRepository.findById(id);
       return studentEntity.orElse(null);
    }

    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> students = studentRepository.findAll();
        return students;
    }
}
