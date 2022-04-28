package com.michelle.cookieorder.repositories;

import java.util.List;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michelle.cookieorder.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
	List<Product> findAll();

	Optional<Product> findByNameContaining(String search);
	
	Optional<Product> findById(Long id);
	
	 List<Product>findTop10ByOrderByCreatedAtDesc();
	 
	 List<Product>findTop3ByOrderByCreatedAtDesc();
}
