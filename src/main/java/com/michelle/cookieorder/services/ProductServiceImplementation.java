package com.michelle.cookieorder.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.michelle.cookieorder.models.Product;
import com.michelle.cookieorder.models.User;
import com.michelle.cookieorder.repositories.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	
	@PreAuthorize("hasRole('ROLE_USER')")
    @Transactional
    @Override
    public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
    @PreAuthorize("hasRole('ROLE_USER')")
    @Transactional
    @Override
    public Product getProductById(Long id) {
    	Optional<Product> optionalProduct = productRepository.findById(id);
    	if(optionalProduct.isPresent()) return optionalProduct.get();
    	else return null;
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN') or principal.id == #product.getUser().getId()")
    @Transactional
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN') or principal.id == #product.getUser().getId()")
    @Transactional
    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN') or principal.id == #product.getUser().getId()")
    @Transactional
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
	
	@PreAuthorize("hasRole('ROLE_USER')")
    @Transactional
    @Override
    public Optional<Product> getByName(String search){
		return productRepository.findByNameContaining(search);
	}

}
