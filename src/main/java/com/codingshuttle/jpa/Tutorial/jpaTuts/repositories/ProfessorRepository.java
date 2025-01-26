package com.codingshuttle.jpa.Tutorial.jpaTuts.repositories;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity,Long> {
}
