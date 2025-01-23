package com.codingshuttle.jpa.Tutorial.jpaTuts.repositories;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
