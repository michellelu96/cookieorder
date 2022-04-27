package com.michelle.cookieorder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michelle.cookieorder.models.Order;
import com.michelle.cookieorder.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }
    public Optional<Order> getOrder(Long id){
        return orderRepository.findById(id);
    }
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
}
