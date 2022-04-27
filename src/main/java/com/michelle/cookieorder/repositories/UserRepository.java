package com.michelle.cookieorder.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.michelle.cookieorder.models.User;




public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByEmail(String email);
	User findByUsername(String username);
	List<User> findAll();
}

