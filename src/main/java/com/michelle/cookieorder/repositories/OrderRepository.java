package com.michelle.cookieorder.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michelle.cookieorder.models.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
	List<Order> findAll();

}
