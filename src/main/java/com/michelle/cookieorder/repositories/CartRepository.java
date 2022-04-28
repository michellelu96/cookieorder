package com.michelle.cookieorder.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.michelle.cookieorder.models.Cart;

public interface CartRepository extends CrudRepository<Cart, Long>{
	Optional<Cart> findById(Long id);

}
