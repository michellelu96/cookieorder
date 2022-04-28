package com.michelle.cookieorder.services;

import java.util.List;
import java.util.Optional;


import com.michelle.cookieorder.models.Product;
import com.michelle.cookieorder.models.User;

public interface ProductService {
	List<Product> getAllProducts();
	
	Product getProductById(Long id);
	
	Product createProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct(Long id);

	Optional<Product> getByName(String search);
	
	List<Product> getThreeProducts();
	
}
