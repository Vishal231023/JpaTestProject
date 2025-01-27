package com.codingshuttle.jpa.Tutorial.jpaTuts.services;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.ProfessorEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.StudentEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.SubjectEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.ProfessorRepository;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.StudentRepository;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;

    public SubjectService(SubjectRepository subjectRepository,ProfessorRepository professorRepository,StudentRepository studentRepository) {
        this.subjectRepository = subjectRepository;
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
    }

    public SubjectEntity addSubject(SubjectEntity subject) {
        return subjectRepository.save(subject);
    }

    public SubjectEntity getSubjectById(Long id) {
        Optional<SubjectEntity> subject = subjectRepository.findById(id);
        return subject.orElse(null);
    }

    public List<SubjectEntity> getAllSubject() {
        return subjectRepository.findAll();
    }


    public SubjectEntity assignProfessorToSubject(Long subjectId, Long professorId) {
        ProfessorEntity professor = professorRepository.findById(professorId).orElseThrow(null);
        SubjectEntity subject = subjectRepository.findById(subjectId).orElseThrow(null);

       subject.setProfessor(professor);

        return subjectRepository.save(subject);
    }


    public SubjectEntity assignStudentToSubject(Long subjectId, Long studentId) {
        SubjectEntity subject = subjectRepository.findById(subjectId).orElse(null);
        StudentEntity student = studentRepository.findById(studentId).orElse(null);

        subject.getStudentsSet().add(student);

        return subjectRepository.save(subject);
    }
}
