package com.codingshuttle.jpa.Tutorial.jpaTuts.repositories;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

}
