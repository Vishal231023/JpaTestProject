package com.codingshuttle.jpa.Tutorial.jpaTuts.services;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.ProfessorEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.StudentEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.AdmissionRecordRepository;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.ProfessorRepository;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentService {

    private final StudentRepository studentRepository;
    private final AdmissionRecordRepository admissionRecordRepository;
    private final ProfessorRepository professorRepository;

    public StudentService(StudentRepository studentRepository, AdmissionRecordRepository admissionRecordRepository,ProfessorRepository professorRepository) {
        this.studentRepository = studentRepository;
        this.admissionRecordRepository = admissionRecordRepository;
        this.professorRepository = professorRepository;
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

    public StudentEntity assignProfessorsToStudent(Long studentId, Long professorId) {
        StudentEntity student = studentRepository.findById(studentId).orElse(null);
        ProfessorEntity professor = professorRepository.findById(professorId).orElse(null);

        student.getProfessorsSet().add(professor);
        return  studentRepository.save(student);
    }
}
