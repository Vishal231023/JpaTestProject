package com.codingshuttle.jpa.Tutorial.jpaTuts.controllers;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.AdmissionRecordEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.ProfessorEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.services.ProfessorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/professors")
@Validated
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ProfessorEntity addProfessor(@RequestBody ProfessorEntity professor){
        return professorService.addProfessor(professor);
    }

    @GetMapping(path = "/{id}")
    public ProfessorEntity getProfessorById(@PathVariable Long id){
        return professorService.getProfessorById(id);
    }

    @GetMapping
    public List<ProfessorEntity> getProfessors(){
        return professorService.getProfessors();
    }


}
