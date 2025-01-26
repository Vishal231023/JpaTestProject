package com.codingshuttle.jpa.Tutorial.jpaTuts.services;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.AdmissionRecordEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.StudentEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.AdmissionRecordRepository;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdmissionRecordService {

    private AdmissionRecordRepository admissionRecordRepository;
    private StudentRepository studentRepository;

    public AdmissionRecordService(AdmissionRecordRepository admissionRecordRepository, StudentRepository studentRepository) {
        this.admissionRecordRepository = admissionRecordRepository;
        this.studentRepository = studentRepository;
    }

    public AdmissionRecordEntity addAdmissionRecord(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordRepository.save(admissionRecordEntity);
    }

    public AdmissionRecordEntity getRecordById(Long id) {
        Optional<AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepository.findById(id);
        return admissionRecordEntity.orElse(null);
    }

    public List<AdmissionRecordEntity> getAllAdmissionRecords() {
        List<AdmissionRecordEntity> admissionRecords = admissionRecordRepository.findAll();
        return admissionRecords;
    }

    public AdmissionRecordEntity assignStudentToRecord(Long recordId, Long studentId) {
//        Optional<AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepository.findById(recordId);
//
//        Optional<StudentEntity> studentEntity = studentRepository.findById(studentId);
//
//        return admissionRecordEntity
//                .flatMap(admissionEntity ->
//                        studentEntity.map(student -> {
//                            admissionEntity.setStudent(student);
//                            return admissionRecordRepository.save(admissionEntity);
//                        })).orElse(null);

        AdmissionRecordEntity record = admissionRecordRepository.findById(recordId).orElseThrow(() -> new RuntimeException("Record not found"));
        StudentEntity student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));

        record.setStudent(student);
        return admissionRecordRepository.save(record);
     }
}
