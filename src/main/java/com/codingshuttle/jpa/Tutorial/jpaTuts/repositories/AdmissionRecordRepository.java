package com.codingshuttle.jpa.Tutorial.jpaTuts.repositories;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecordEntity,Long> {
}
