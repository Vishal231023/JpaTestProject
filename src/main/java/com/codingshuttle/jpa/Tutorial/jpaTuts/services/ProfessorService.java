package com.codingshuttle.jpa.Tutorial.jpaTuts.services;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.AdmissionRecordEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.ProfessorEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.SubjectEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.ProfessorRepository;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private  final SubjectRepository subjectRepository;

    public ProfessorService(ProfessorRepository professorRepository, SubjectRepository subjectRepository) {
        this.professorRepository = professorRepository;
        this.subjectRepository = subjectRepository;
    }

    public ProfessorEntity addProfessor(ProfessorEntity professor) {
        return professorRepository.save(professor);
    }

    public ProfessorEntity getProfessorById(Long id) {
        Optional<ProfessorEntity> professor = professorRepository.findById(id);
        return professor.orElse(null);
    }

    public List<ProfessorEntity> getProfessors() {
        return professorRepository.findAll();
    }


}
