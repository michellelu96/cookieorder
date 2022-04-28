package com.michelle.cookieorder.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.michelle.cookieorder.models.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long>{
	List<OrderItem> findAll();
}
