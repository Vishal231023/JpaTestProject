package com.codingshuttle.jpa.Tutorial.jpaTuts.services;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.ProfessorEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.SubjectEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.ProfessorRepository;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ProfessorRepository professorRepository;

    public SubjectService(SubjectRepository subjectRepository,ProfessorRepository professorRepository) {
        this.subjectRepository = subjectRepository;
        this.professorRepository = professorRepository;
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
}
