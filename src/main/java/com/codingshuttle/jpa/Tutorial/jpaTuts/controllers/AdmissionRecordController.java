package com.codingshuttle.jpa.Tutorial.jpaTuts.controllers;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.AdmissionRecordEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.StudentEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.services.AdmissionRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admissionRecords")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

     @PostMapping
    public AdmissionRecordEntity addAdmissionRecord(@RequestBody AdmissionRecordEntity admissionRecordEntity){
        return admissionRecordService.addAdmissionRecord(admissionRecordEntity);
    }

    @GetMapping("/{id}")
    public AdmissionRecordEntity getRecordById(@PathVariable Long id){
        return admissionRecordService.getRecordById(id);
    }

    @GetMapping
    public List<AdmissionRecordEntity> getAllAdmissionRecords() {
        return admissionRecordService.getAllAdmissionRecords();
    }

    @PutMapping("/{recordId}/assign-student/{studentId}")
    public AdmissionRecordEntity assignStudentToRecord(@PathVariable Long recordId, @PathVariable Long studentId) {
        return admissionRecordService.assignStudentToRecord(recordId, studentId);
    }
}
