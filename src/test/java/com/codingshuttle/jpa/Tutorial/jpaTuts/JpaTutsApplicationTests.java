package com.codingshuttle.jpa.Tutorial.jpaTuts;

import com.codingshuttle.jpa.Tutorial.jpaTuts.entities.ProductEntity;
import com.codingshuttle.jpa.Tutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
class JpaTutsApplicationTests {
	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity entity = ProductEntity.builder()
				.sku("nestle1234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();

		ProductEntity savedProductEntity = productRepository.save(entity);
		System.out.println(savedProductEntity);


	}

	@Test
	void getRepository(){
		List<ProductEntity> entities = productRepository.findAll();
		System.out.println(entities);
	}

	@Test
	void getProductTitleWise(){

		List<ProductEntity> entities = productRepository.findByTitle("Pepsi");

		System.out.println(entities);
	}

	@Test
	void getProduct(){

		List<ProductEntity> entities = productRepository.findByCreatedAtAfter(
				LocalDateTime.of(2025,1,1,0,0,0,0));

		System.out.println(entities);
	}

	@Test
	void getProductQtyAndPriceWise(){

		List<ProductEntity> entities = productRepository.findByQuantityAndPrice(4,BigDecimal.valueOf(12.4));

		System.out.println(entities);
	}

}
