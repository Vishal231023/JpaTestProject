package com.codingshuttle.jpa.Tutorial.jpaTuts.controllers;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.ProfessorEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.SubjectEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.services.SubjectService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/subjects")
@Validated
public class SubjectController {

    private  final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public SubjectEntity addSubject(@RequestBody SubjectEntity subject){
        return  subjectService.addSubject(subject);
    }

    @GetMapping(path = "{id}")
    public SubjectEntity getSubjectById(@PathVariable Long id){
        return subjectService.getSubjectById(id);
    }

    @GetMapping
    public List<SubjectEntity> getAllSubject(){
        return subjectService.getAllSubject();
    }

    @PutMapping("/{subjectId}/assign-professor/{professorId}")
    public SubjectEntity assignProfessorToSubject(@PathVariable Long subjectId, @PathVariable Long professorId) {
        return subjectService.assignProfessorToSubject(subjectId, professorId);
    }
}
