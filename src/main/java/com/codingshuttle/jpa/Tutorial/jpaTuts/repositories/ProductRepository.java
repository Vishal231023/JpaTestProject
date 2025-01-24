package com.codingshuttle.jpa.Tutorial.jpaTuts.repositories;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findByTitle(String title);
    List<ProductEntity> findByCreatedAtAfter(LocalDateTime localDateTime);

    List<ProductEntity> findByQuantityAndPrice(int quantity, BigDecimal price);

    List<ProductEntity> findBy(Sort sort);
}
